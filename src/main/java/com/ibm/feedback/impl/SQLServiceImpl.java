package com.ibm.feedback.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.feedback.FeedbackException;
import com.ibm.feedback.model.dao.AuthRequest;
import com.ibm.feedback.model.dao.AuthResponse;
import com.ibm.feedback.model.dao.SQLExecute;
import com.ibm.feedback.model.dao.SQLJob;
import com.ibm.feedback.model.dao.SQLResults;

@Service("sql")
public class SQLServiceImpl implements SQLService {
	public SQLServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String createInsertValues(List<String> values) {
		String valString = "( ";
		//valueString
		Iterator<String> val = values.iterator();
		while(val.hasNext())
		{
			String value = val.next();
			valString = valString+"'"+value+"',";
		}
		valString = valString.substring(0, valString.length() - 1)+")";
		return valString;
	}


	@Override
	public String getAuthorizationToken(String userid,String password,String url,RestTemplate restTemplate) throws FeedbackException
	{
		String token = "";
		try
		{
			
		AuthRequest AuthorizationRequest =new AuthRequest(userid,password);
    	ResponseEntity<AuthResponse> response = restTemplate.postForEntity(url,AuthorizationRequest,AuthResponse.class);	
    	token = response.getBody().gettoken();
    	if (token.isEmpty())
    		{
    		throw new FeedbackException("Unable to get token from Database Service");
    		}
		}
		
		catch (Exception e){
			throw new FeedbackException("Unable to get token from Database Service");
		}
		return token;
		}
	@Override
	 public String executeSelectCall(String sqlStatement ,String authToken,String url,RestTemplate restTemplate ) throws FeedbackException {
	    	
		 	SQLExecute Request = new SQLExecute();
		 	Request.setCommands(sqlStatement);
		 	Request.setLimit(100);
		 	Request.setSeparator(";");
		 	Request.setStopOnError("yes");
		 	 ObjectMapper mapper = new ObjectMapper();
		 	String jsonString="";
		 	String response ="";
			try {
				jsonString = mapper.writeValueAsString(Request); 
				HttpHeaders headers = new HttpHeaders();
		        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
		        headers.add("User-Agent", "Spring's RestTemplate" );  // value can be whatever
		        headers.add("Authorization", "Bearer "+authToken );
		        HttpEntity< String > entity = new HttpEntity<>(jsonString, headers);
		        ResponseEntity<SQLJob> responseEntity = restTemplate.postForEntity(url,entity,SQLJob.class);
		        
		       response = responseEntity.getBody().getId();
				if (response.equals(null) || response.isEmpty())
				{
					throw new FeedbackException("Error While executing SQL Statements");
				}
				
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}	
			catch (FeedbackException e) {
				// TODO Auto-generated catch block
				throw  new FeedbackException("Error While executing SQL Statements");
				
			}
				
				
			
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			return response;
			
	 }
	@Override
	 public SQLResults getResults(String authToken,String url,RestTemplate restTemplate ) throws FeedbackException {
		SQLResults res = new SQLResults();
		 	try {
				String Request = "";
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));        
				headers.add("User-Agent", "Spring's RestTemplate" );  // value can be whatever
				headers.add("Authorization", "Bearer "+authToken );
				System.out.println(Request);
				HttpEntity< String > entity = new HttpEntity<>(Request, headers);
				ResponseEntity<SQLResults> response = restTemplate.exchange(url,HttpMethod.GET,entity,SQLResults.class);
				
				if(! response.getBody().getResults().get(0).getError().equals(null) && !response.getBody().getResults().get(0).getError().isEmpty())
				{
				
				res = response.getBody();
				}
				else 
				{
					throw  new FeedbackException("Error While executing SQL Statements"+response.getBody().getResults().get(0).getError());
				}
			} catch (FeedbackException e) {
				// TODO Auto-generated catch block
				throw  new FeedbackException(e);
			}
		 	return res;
	 }
	 
	@Override
	 public SQLResults getSQLResults(String userid,String password,String authUrl,String sql,String url,RestTemplate restTemplate) throws FeedbackException {
		//2.1 Get Authorization Token
		 String token = getAuthorizationToken(userid,password,authUrl, restTemplate);
		//2.2 SQL COmmands Step
		 String sqlId=executeSelectCall(sql,token,url, restTemplate);
		 //2.3 Get SQL Results 
			SQLResults sqlResults = getResults(token,url+"/"+sqlId, restTemplate);
		 return sqlResults;
	 }

}
