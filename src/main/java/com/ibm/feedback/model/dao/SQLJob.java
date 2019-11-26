package com.ibm.feedback.model.dao;


public class SQLJob {

private Integer commandsCount;
private Integer limit;
private String id;

/**
* No args constructor for use in serialization
*
*/
public SQLJob() {
}

/**
*
* @param commandsCount
* @param limit
* @param id
*/
public SQLJob(Integer commandsCount, Integer limit, String id) {
super();
this.commandsCount = commandsCount;
this.limit = limit;
this.id = id;
}

public Integer getCommandsCount() {
return commandsCount;
}

public void setCommandsCount(Integer commandsCount) {
this.commandsCount = commandsCount;
}

public Integer getLimit() {
return limit;
}

public void setLimit(Integer limit) {
this.limit = limit;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

}
