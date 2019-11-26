package com.ibm.feedback.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.feedback.model.Customer;
import com.ibm.feedback.model.FeedbackDetails;
import com.ibm.feedback.model.FeedbackQuestion;
import com.ibm.feedback.model.dao.ResultModel;
import com.ibm.feedback.model.dao.SQLResults;
@Service("feedback")
public class FeedbackImpl implements FeedbackService {
	
	
	
	public FeedbackImpl() {
		
	}
	 
	@Override
	 public Customer getCustomerDetails(SQLResults sqlResults)
		{ 
			ResultModel Result = sqlResults.getResults().get(0);
			List <String> CustomerResult = Result.getRows().get(0);
			Customer customer = new Customer();
			
			customer.setId(Integer.parseInt(CustomerResult.get(0)));
			customer.setFirstName(CustomerResult.get(1));
			customer.setLastName(CustomerResult.get(2));
			customer.setPhoneNumber(CustomerResult.get(3));
			customer.setEmail(CustomerResult.get(4));
			customer.setPlace(CustomerResult.get(5));
			customer.setDate(CustomerResult.get(6));
			customer.setType(CustomerResult.get(7));
			
			return customer;
			
		}
	@Override
	 
	 public FeedbackDetails getFeedbackDetails(SQLResults sqlResults)
		{ 
			
		 FeedbackDetails feedbackDetails = new FeedbackDetails();
		 
		 ResultModel Result = sqlResults.getResults().get(0);
		 List <FeedbackQuestion>feedbackQuestionList = new ArrayList<FeedbackQuestion>()  ;
		 FeedbackQuestion feedbackQuestion = new FeedbackQuestion();
			Iterator<List<String>> iterator = Result.getRows().iterator();
		      while(iterator.hasNext()) {
		    	  List<String> questions =  iterator.next();
		    	  feedbackQuestion = new FeedbackQuestion();
		    	  feedbackQuestion.setFeedbackQuestionId(questions.get(0));
		    	  feedbackQuestion.setFeedbackQuestionCategory(questions.get(1));
		    	  feedbackQuestion.setFeedbackQuestionSubCategory(questions.get(2));
		    	  feedbackQuestion.setFeedbackQuestion(questions.get(3));
		    	  feedbackQuestion.setMandatory(questions.get(4));
		    	  feedbackQuestionList.add(feedbackQuestion);
		      }
			
			feedbackDetails.setFeedbackQuestions(feedbackQuestionList);
			return feedbackDetails;
		}}
