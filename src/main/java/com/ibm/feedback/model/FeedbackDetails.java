package com.ibm.feedback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.persistence.Access;
import javax.persistence.AccessType;

@Entity
@Access(AccessType.PROPERTY)
public class FeedbackDetails {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

@Valid
private List<FeedbackQuestion> feedbackQuestions = null;


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
public FeedbackDetails() {
}

/**
*
* @param feedbackQuestions
*/
public FeedbackDetails(List<FeedbackQuestion> feedbackQuestions) {
super();
this.feedbackQuestions = feedbackQuestions;
}

public List<FeedbackQuestion> getFeedbackQuestions() {
return feedbackQuestions;
}

public void setFeedbackQuestions(List<FeedbackQuestion> feedbackQuestions) {
this.feedbackQuestions = feedbackQuestions;
}

}