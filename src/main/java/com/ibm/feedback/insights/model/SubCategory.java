package com.ibm.feedback.insights.model;

public class SubCategory {

private String rating;
private String name;

/**
* No args constructor for use in serialization
*
*/
public SubCategory() {
}

/**
*
* @param rating
*/
public SubCategory(String rating) {
super();
this.rating = rating;
}

public String getRating() {
return rating;
}

public void setRating(String rating) {
this.rating = rating;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

}