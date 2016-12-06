package com.bcbs.sentimentanalysis.model;

public class Login {
public String userName;
public String password;
public Integer errorcode;
public String errorMessage;
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getErrorcode() {
	return errorcode;
}
public void setErrorcode(Integer errorcode) {
	this.errorcode = errorcode;
}
public String getErrorMessage() {
	return errorMessage;
}
public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}



}
