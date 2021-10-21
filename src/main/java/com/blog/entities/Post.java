package com.blog.entities;

import java.sql.Timestamp;

public class Post {
  
	private int pid;
	private String ptitle;
	private String pcontent;
	private String code;
	private Timestamp pdate;
	private int catid;
	private int userloginid;
	
	
	public int getUserloginid() {
		return userloginid;
	}
	public void setUserloginid(int userloginid) {
		this.userloginid = userloginid;
	}
	public Post(String ptitle, String pcontent, String code, Timestamp pdate, int catid, int userloginid) {
		super();
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.code = code;
		this.pdate = pdate;
		this.catid = catid;
		this.userloginid = userloginid;
	}
	public Post(int pid, String ptitle, String pcontent, String code, Timestamp pdate, int catid, int userloginid) {
		super();
		this.pid = pid;
		this.ptitle = ptitle;
		this.pcontent = pcontent;
		this.code = code;
		this.pdate = pdate;
		this.catid = catid;
		this.userloginid = userloginid;
	}
	public Post() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPtitle() {
		return ptitle;
	}
	public void setPtitle(String ptitle) {
		this.ptitle = ptitle;
	}
	public String getPcontent() {
		return pcontent;
	}
	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	
	
}
