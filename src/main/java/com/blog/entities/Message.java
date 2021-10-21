package com.blog.entities;

public class Message {
private String msgcontent;
private String msgType;
public Message() {
	super();
}
public Message(String msgcontent, String msgType) {
	super();
	this.msgcontent = msgcontent;
	this.msgType = msgType;
}
public String getMsgcontent() {
	return msgcontent;
}
public void setMsgcontent(String msgcontent) {
	this.msgcontent = msgcontent;
}
public String getMsgType() {
	return msgType;
}
public void setMsgType(String msgType) {
	this.msgType = msgType;
}


}
