package com.ibm.feedback.impl;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.ibm.feedback.FeedbackException;
import com.ibm.feedback.model.dao.SQLResults;

public interface SQLService {
	public abstract String createInsertValues(List<String> values);
	public abstract String getAuthorizationToken(String userid,String password,String url,RestTemplate restTemplate) throws FeedbackException;
	public abstract String executeSelectCall(String sqlStatement ,String authToken,String url,RestTemplate restTemplate ) throws FeedbackException;
	public abstract SQLResults getResults(String authToken,String url,RestTemplate restTemplate ) throws FeedbackException;
	public abstract SQLResults getSQLResults(String userid,String password,String authUrl,String sql,String url,RestTemplate restTemplate) throws FeedbackException ;
	

}
