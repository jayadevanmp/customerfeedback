package com.ibm.feedback.insights.model;
import java.util.List;
public class FeedbacInsights {

private Overall overall;
private List<Category> category = null;

/**
* No args constructor for use in serialization
*
*/
public FeedbacInsights() {
}

/**
*
* @param overall
* @param category
*/
public FeedbacInsights(Overall overall, List<Category> category) {
super();
this.overall = overall;
this.category = category;
}

public Overall getOverall() {
return overall;
}

public void setOverall(Overall overall) {
this.overall = overall;
}

public List<Category> getCategory() {
return category;
}

public void setCategory(List<Category> category) {
this.category = category;
}

}