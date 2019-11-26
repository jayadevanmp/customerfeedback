package com.ibm.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import javax.persistence.Access;
import javax.persistence.AccessType;

@Entity
@Access(AccessType.PROPERTY)

public class FeedbackQuestion {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}


@NotEmpty
private String feedbackQuestionCategory;
@NotEmpty
private String feedbackQuestionSubCategory;
@NotEmpty
private String feedbackQuestionId;
@NotEmpty
private String feedbackQuestion;
@NotEmpty
private String feedbackAnswer;
private String mandatory;
/**
* No args constructor for use in serialization
*
*/
public FeedbackQuestion() {
}

/**
*
* @param feedbackAnswer
* @param feedbackQuestionId
* @param feedbackQuestionSubCategory
* @param feedbackQuestionCategory
* @param mandatory
* @param feedbackQuestion
*/
public FeedbackQuestion(String feedbackQuestionCategory, String feedbackQuestionSubCategory, String feedbackQuestionId, String feedbackQuestion, String feedbackAnswer, String mandatory) {
super();
this.feedbackQuestionCategory = feedbackQuestionCategory;
this.feedbackQuestionSubCategory = feedbackQuestionSubCategory;
this.feedbackQuestionId = feedbackQuestionId;
this.feedbackQuestion = feedbackQuestion;
this.feedbackAnswer = feedbackAnswer;
this.mandatory = mandatory;
}

public String getFeedbackQuestionCategory() {
return feedbackQuestionCategory;
}

public void setFeedbackQuestionCategory(String feedbackQuestionCategory) {
this.feedbackQuestionCategory = feedbackQuestionCategory;
}

public String getFeedbackQuestionSubCategory() {
return feedbackQuestionSubCategory;
}

public void setFeedbackQuestionSubCategory(String feedbackQuestionSubCategory) {
this.feedbackQuestionSubCategory = feedbackQuestionSubCategory;
}

public String getFeedbackQuestionId() {
return feedbackQuestionId;
}

public void setFeedbackQuestionId(String feedbackQuestionId) {
this.feedbackQuestionId = feedbackQuestionId;
}

public String getFeedbackQuestion() {
return feedbackQuestion;
}

public void setFeedbackQuestion(String feedbackQuestion) {
this.feedbackQuestion = feedbackQuestion;
}

public String getFeedbackAnswer() {
return feedbackAnswer;
}

public void setFeedbackAnswer(String feedbackAnswer) {
this.feedbackAnswer = feedbackAnswer;
}

public String getMandatory() {
return mandatory;
}

public void setMandatory(String mandatory) {
this.mandatory = mandatory;
}
}