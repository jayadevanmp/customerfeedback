package com.ibm.feedback.insights.model;

import java.util.ArrayList;
import java.util.List;

public class Category {
private String name;
private String count;
private String rating;
private List<SubCategory> subCategory = new ArrayList<SubCategory>() ;

/**
* No args constructor for use in serialization
*
*/
public Category() {
}

/**
*
* @param subCategory
* @param count
* @param rating
*/
public Category(String count, String rating, List<SubCategory> subCategory) {
super();
this.count = count;
this.rating = rating;
this.subCategory = subCategory;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
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

public List<SubCategory> getSubCategory() {
return subCategory;
}

public void setSubCategory(List<SubCategory> subCategory) {
this.subCategory = subCategory;
}

}