package com.ibm.feedback.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ibm.feedback.model.Customer;
import com.ibm.feedback.model.FeedbackDetails;
import com.ibm.feedback.model.FeedbackForm;
import com.ibm.feedback.model.dao.AuthRequest;
import com.ibm.feedback.model.dao.AuthResponse;

public class Feedback {

	
	int id ;
	public Feedback() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
