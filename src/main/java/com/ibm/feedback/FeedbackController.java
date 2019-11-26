package com.ibm.feedback;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ibm.feedback.impl.FeedbackService;
import com.ibm.feedback.impl.SQLService;
import com.ibm.feedback.insights.model.Category;
import com.ibm.feedback.insights.model.FeedbacInsights;
import com.ibm.feedback.insights.model.Overall;
import com.ibm.feedback.insights.model.SubCategory;
import com.ibm.feedback.model.Customer;
import com.ibm.feedback.model.FeedbackDetails;
import com.ibm.feedback.model.FeedbackForm;
import com.ibm.feedback.model.FeedbackQuestion;
import com.ibm.feedback.model.dao.SQLResults;

@RestController
public class FeedbackController {
	@Bean
    public RestTemplate RestTemplate() {
    return new RestTemplate();
    }
	@Autowired
	RestTemplate restTemplate;
	
	
	@Autowired
	SQLService sqlDatabase ;

	@Autowired
	FeedbackService feedback ;
	
	@Autowired
	Environment env;

	@Value("${app.sql.userid}")
	private String userid;
	
	@Value("${app.sql.password}")
	private String password;
	
	@Value("${app.sql.conn.auth.url}")
	private String authUrl;
	
	@Value("${app.sql.conn.sqlexecute.url}")
	private String url;
	
	
	
	
	@GetMapping("v1/feedback/{id}")    
    public FeedbackForm getFeedbackQuestions(@PathVariable int id) throws FeedbackException {
		
		//**************************************************STEP 1 
		FeedbackForm response;
		response = new FeedbackForm();
		try {
			
			String sql = env.getProperty("app.sql.select.customer")+id;
			SQLResults sqlResults=sqlDatabase.getSQLResults( userid, password, authUrl, sql, url,restTemplate);
			Customer customer = feedback.getCustomerDetails(sqlResults);
			String type = customer.getType();
			
			sql = env.getProperty("app.sql.select.questions")+"'"+type+"'";
			sqlResults=sqlDatabase.getSQLResults( userid, password, authUrl, sql, url,restTemplate);
			FeedbackDetails feedbackDetails = feedback.getFeedbackDetails(sqlResults);
					
					response.setCustomer(customer);
					response.setFeedbackDetails(feedbackDetails);
		} catch (FeedbackException e) {
			
			throw new FeedbackException(e);
		}
catch (Exception e) {
			
	throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		return response;
	}
    		
	
	
	@PostMapping("v1/feedback")
	public String saveFeedbackAnswers(@Valid @RequestBody FeedbackForm feedbackform) 
	{
		try {
			String customerID = feedbackform.getCustomer().getId().toString();
			String Type = feedbackform.getCustomer().getType();
			List<FeedbackQuestion> FeedbackDetails = feedbackform.getFeedbackDetails().getFeedbackQuestions();
			Iterator<FeedbackQuestion> iterator = FeedbackDetails.iterator();
			List<String> values = new ArrayList<String>();
			String value ="";
			while (iterator.hasNext())
			{
				FeedbackQuestion questions =  iterator.next();
				values.add("11");
				values.add(questions.getFeedbackQuestionId());
				values.add(Type);
				values.add(questions.getFeedbackQuestionSubCategory());
				values.add(questions.getFeedbackAnswer());
				values.add(customerID);
				value = value+sqlDatabase.createInsertValues(values)+",";
				values = new ArrayList<String>();
				
			}
			value = value.substring(0, value.length() - 1);
			
			String sql = env.getProperty("app.sql.insert.answers")+value;
			SQLResults sqlResults=sqlDatabase.getSQLResults( userid, password, authUrl, sql, url,restTemplate);
			
			//2.4 Transform it to Customer Data Object
			if (sqlResults.getStatus().equals("completed"))
			{
			return "success";
			}
			else
				throw new FeedbackException("Unable to access data from database");
		}
		
		catch (FeedbackException e) {
				// TODO Auto-generated catch block
				
				throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
			}
		catch (Exception e ) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		
	}
	
	@GetMapping("v1/feedback/result")
	public FeedbacInsights getFeedbackResults()
	{  
		FeedbacInsights insights = new FeedbacInsights();
		try {
			Overall overall = new Overall();
			String average = "";
			Double avg=0.0;
			String count ="";
			String sqlrating = env.getProperty("app.sql.select.feedbackresults");
			SQLResults sqlRatingResults=sqlDatabase.getSQLResults( userid, password, authUrl, sqlrating, url,restTemplate);
			 count = sqlRatingResults.getResults().get(0).getRows().get(0).get(0);
			 average = sqlRatingResults.getResults().get(0).getRows().get(0).get(1);
			 overall.setCount(count);
			 overall.setRating(average);
			 insights.setOverall(overall);
			System.out.println("OVERALL" +avg.toString());
			String sql = env.getProperty("app.sql.select.feedbackcategory");
			SQLResults sqlResults=sqlDatabase.getSQLResults( userid, password, authUrl, sql, url,restTemplate);
			if (!sqlResults.getStatus().equals("completed"))
			{	throw new FeedbackException("Unable to access data from database");
		}
			
			List<List<String>> rows = sqlResults.getResults().get(0).getRows();
			List<Category> CategoryList = new ArrayList<Category>() ;
			Iterator<List<String>> iterator = rows.iterator();
			while (iterator.hasNext())
			{
				String category = iterator.next().get(0);
				Category cat = new Category();
				System.out.println("Category"+category);
				String sqlcat = env.getProperty("app.sql.select.feedbackresultscategory") +"'"+category+"'";
				SQLResults sqlcatResults=sqlDatabase.getSQLResults( userid, password, authUrl, sqlcat, url,restTemplate);
				List<List<String>> catdata = sqlcatResults.getResults().get(0).getRows();
				cat.setName(category);
				cat.setCount(catdata.get(0).get(0));
				cat.setRating(catdata.get(0).get(1));
				
				String sqlsub = env.getProperty("app.sql.select.feedbacksubcategory")+"'"+category+"'";
				SQLResults sqlsubResults=sqlDatabase.getSQLResults( userid, password, authUrl, sqlsub, url,restTemplate);
				if (!sqlResults.getStatus().equals("completed"))
				{	throw new FeedbackException("Unable to access data from database");
			}
				List<List<String>> subrows = sqlsubResults.getResults().get(0).getRows();
				Iterator<List<String>> subiterator = subrows.iterator();
				List<SubCategory> subCategoryList = new ArrayList<SubCategory>() ;
				while (subiterator.hasNext())
				{
					SubCategory subcat =new SubCategory();
					String subcategory = subiterator.next().get(0);
					System.out.println("subcategory"+subcategory);
					String sqldata = env.getProperty("app.sql.select.feedbackresults") +" WHERE \"Category\"='"+category+"' AND \"SubCategory\"='"+subcategory+"'";
					SQLResults sqldataResults=sqlDatabase.getSQLResults( userid, password, authUrl, sqldata, url,restTemplate);
					if (!sqlResults.getStatus().equals("completed"))
					{	throw new FeedbackException("Unable to access data from database");
					}
					List<List<String>> subdata = sqldataResults.getResults().get(0).getRows();
					System.out.println("Avg");
					subcat.setRating(subdata.get(0).get(0));
					subcat.setName(subcategory);
					subCategoryList.add(subcat);
					}
				cat.setSubCategory(subCategoryList);
				CategoryList.add(cat);
			}
			
			insights.setCategory(CategoryList);
		} catch (FeedbackException e) {
			// TODO Auto-generated catch block
			
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage(), e);
		}
		return insights;
	}
		
	}    
