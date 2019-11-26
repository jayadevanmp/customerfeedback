package com.ibm.feedback.model.dao;

import java.util.List;

public class ResultModel {

private Integer rowsCount;
private Double runtimeSeconds;
private List<String> columns = null;
private List<String> columnsType = null;
private Integer limit;
private Integer index;
private List<List<String>> rows = null;
private String error;
private String command;

/**
* No args constructor for use in serialization
*
*/
public ResultModel() {
}

/**
*
* @param rowsCount
* @param columns
* @param limit
* @param index
* @param runtimeSeconds
* @param rows
* @param columnsType
* @param command
*/
public ResultModel(Integer rowsCount, Double runtimeSeconds, List<String> columns, List<String> columnsType, Integer limit, Integer index, List<List<String>> rows, String command) {
super();
this.rowsCount = rowsCount;
this.runtimeSeconds = runtimeSeconds;
this.columns = columns;
this.columnsType = columnsType;
this.limit = limit;
this.index = index;
this.rows = rows;
this.command = command;
}

public Integer getRowsCount() {
return rowsCount;
}

public void setRowsCount(Integer rowsCount) {
this.rowsCount = rowsCount;
}

public Double getRuntimeSeconds() {
return runtimeSeconds;
}

public void setRuntimeSeconds(Double runtimeSeconds) {
this.runtimeSeconds = runtimeSeconds;
}

public List<String> getColumns() {
return columns;
}

public void setColumns(List<String> columns) {
this.columns = columns;
}

public List<String> getColumnsType() {
return columnsType;
}

public void setColumnsType(List<String> columnsType) {
this.columnsType = columnsType;
}

public Integer getLimit() {
return limit;
}

public void setLimit(Integer limit) {
this.limit = limit;
}

public Integer getIndex() {
return index;
}

public void setIndex(Integer index) {
this.index = index;
}

public List<List<String>> getRows() {
return rows;
}

public void setRows(List<List<String>> rows) {
this.rows = rows;
}

public String getCommand() {
return command;
}

public void setCommand(String command) {
this.command = command;
}

public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

}