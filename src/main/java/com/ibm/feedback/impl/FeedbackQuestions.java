package com.ibm.feedback.impl;

import com.ibm.feedback.model.FeedbackDetails;

public class FeedbackQuestions {
	
	public FeedbackQuestions() 
	{};
	
	String type ; 
	
	public FeedbackDetails getFeedbackQuestions(String type)
	{
		FeedbackDetails details = new FeedbackDetails();
		
		return details;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
