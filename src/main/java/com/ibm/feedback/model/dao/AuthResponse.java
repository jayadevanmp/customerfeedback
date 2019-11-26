package com.ibm.feedback.model.dao;



public class AuthResponse {

private String userid;
private String token;

public String getUserid() {
return userid;
}

public void setUserid(String userid) {
this.userid = userid;
}

public String gettoken() {
return token;
}

public void settoken(String token) {
this.token = token;
}
public AuthResponse()
{
}
public AuthResponse(String userid, String token) {
    this.userid = userid;
    this.token = token;
}
}