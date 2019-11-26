package com.ibm.feedback.model.dao;



public class AuthRequest {

private String userid;
private String password;

public String getUserid() {
return userid;
}

public void setUserid(String userid) {
this.userid = userid;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}
public AuthRequest()
{
}
public AuthRequest(String userid, String password) {
    this.userid = userid;
    this.password = password;
}
}