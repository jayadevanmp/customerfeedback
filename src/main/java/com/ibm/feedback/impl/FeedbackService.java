package com.ibm.feedback.impl;

import com.ibm.feedback.model.Customer;
import com.ibm.feedback.model.FeedbackDetails;
import com.ibm.feedback.model.dao.SQLResults;

public interface FeedbackService {
	public abstract Customer getCustomerDetails(SQLResults sqlResults);
	public abstract FeedbackDetails getFeedbackDetails(SQLResults sqlResults);

}
