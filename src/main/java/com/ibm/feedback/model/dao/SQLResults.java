package com.ibm.feedback.model.dao;

import java.util.List;

public class SQLResults {

private String id;
private List<ResultModel> results = null;
private String status;

/**
* No args constructor for use in serialization
*
*/
public SQLResults() {
}

/**
*
* @param id
* @param results
* @param status
*/
public SQLResults(String id, List<ResultModel> results, String status) {
super();
this.id = id;
this.results = results;
this.status = status;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public List<ResultModel> getResults() {
return results;
}

public void setResults(List<ResultModel> results) {
this.results = results;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

}
