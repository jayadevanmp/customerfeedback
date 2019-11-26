package com.ibm.feedback.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SQLExecute {

private String commands ;
private Integer limit;
private String separator ;

@JsonProperty("stop_on_error")
private String stop_on_error;


/* No args constructor for use in serialization
*
*/
public SQLExecute() {
}
public SQLExecute(String commands, Integer limit, String separator, String stop_on_error) {
	super();
	this.commands = commands;
	this.limit = limit;
	this.separator = separator;
	this.stop_on_error = stop_on_error;
}


/**
*
* @param commandsCount
* @param limit
* @param id
*/

public String getCommands() {
	return commands;
}

public void setCommands(String commands) {
	this.commands = commands;
}

public Integer getLimit() {
	return limit;
}

public void setLimit(Integer limit) {
	this.limit = limit;
}

public String getSeparator() {
	return separator;
}

public void setSeparator(String separator) {
	this.separator = separator;
}
@JsonProperty("stop_on_error")
public String getStopOnError() {
	return stop_on_error;
}
@JsonProperty("stop_on_error")
public void setStopOnError(String stop_on_error) {
	this.stop_on_error = stop_on_error;
}

}
