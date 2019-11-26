package com.ibm.feedback.insights.model;

public class Overall {

private String count;
private String rating;

/**
* No args constructor for use in serialization
*
*/
public Overall() {
}

/**
*
* @param count
* @param rating
*/
public Overall(String count, String rating) {
super();
this.count = count;
this.rating = rating;
}

public String getCount() {
return count;
}

public void setCount(String count) {
this.count = count;
}

public String getRating() {
return rating;
}

public void setRating(String rating) {
this.rating = rating;
}

}