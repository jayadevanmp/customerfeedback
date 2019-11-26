package com.ibm.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.persistence.Access;
import javax.persistence.AccessType;

@Entity
public class FeedbackForm {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
	
@Valid
private Customer customer;
@Valid
private FeedbackDetails feedbackDetails;
	

public Long getId() {
		return id;
}

public void setId(Long id) {
		this.id = id;
}


/**
* No args constructor for use in serialization
*
*/
public FeedbackForm() {
}

/**
*
* @param feedbackDetails
* @param user
*/


public FeedbackForm(Customer customer, FeedbackDetails feedbackDetails) {
super();
this.customer = customer;
this.feedbackDetails = feedbackDetails;
}


public Customer getCustomer() {
return customer;
}

public void setCustomer(Customer customer) {
this.customer = customer;
}

public FeedbackDetails getFeedbackDetails() {
return feedbackDetails;
}

public void setFeedbackDetails(FeedbackDetails feedbackDetails) {
this.feedbackDetails = feedbackDetails;
}

}
