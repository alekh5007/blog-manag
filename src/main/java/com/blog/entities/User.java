package com.blog.entities;

public class User {
private int userid;
private String name;
private String email;
private String password;
private String address;
private boolean gender;
public User() {
	
}
public User(int userid, String name, String email, String password, String address, Boolean gender) {
	super();
	this.userid = userid;
	this.name = name;
	this.email = email;
	this.password = password;
	this.address = address;
	this.gender = gender;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public boolean getGender() {
	return gender;
}
public void setGender(boolean gender) {
	this.gender = gender;
}


 
}
