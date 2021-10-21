package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.entities.Categorie;
import com.blog.entities.Post;

public class PostDao {
 
	 Connection con;


	public PostDao(Connection con) {
		super();
		this.con = con;
	}
	
	public ArrayList<Categorie> getAllCategorie(){

		
		ArrayList<Categorie> list=new ArrayList<Categorie>();
		   try {
			   
			   String query="Select * from Categories";
			   Statement st=this.con.createStatement();
			   ResultSet set = st.executeQuery(query);
			   while(set.next()) {
				  int id= set.getInt("cid");
				  String name=set.getString("name");
				  String descriptin=set.getString("description");
				  Categorie ct=new Categorie(id,name,descriptin);
				  list.add(ct);
				   
			   }
			   
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	//set post
	public  boolean postdata(Post p) {
		boolean flag=false;
		System.out.println("========");
		System.out.println(p.getPtitle());
		
	   try {
		   String query="insert into posts(ptitle,pcontent,pcode,catid,userloginid) values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
		  // PreparedStatement pstmt=this.con.PrepareStatement(query);
			pstmt.setString(1, p.getPtitle());
			pstmt.setString(2, p.getPcontent());
			pstmt.setString(3, p.getCode());
			pstmt.setInt(4, p.getCatid());
			pstmt.setInt(5,p.getUserloginid());
			int row=pstmt.executeUpdate();
			System.out.println("post added");
			flag =true;
		   
		   
	} catch (Exception e) {
	
	}
		
		return flag;
      
	}
	
	//getAllpost()
	public List<Post> getAllpost(){
		List<Post> ls=new ArrayList<Post>();
		
		try {
			 
			   String query="Select * from posts order by pid desc";
			   Statement st=this.con.createStatement();
			   ResultSet set = st.executeQuery(query);
			   while(set.next()) {
				  int pid= set.getInt("pid");
				  String title=set.getString("ptitle");
				  String pcontent=set.getString("pcontent");
				  String pcode=set.getString("pcode");
				  int catid=set.getInt("catid");
				  int userloginid=set.getInt("userloginid");
				  Post ps=new Post(pid,title,pcontent,pcode,null,catid,userloginid);
				 
				  ls.add(ps);
				  
			   }
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		
		return ls;
		
	}
	
	

	
	
	//get post by category
	
	 public List<Post> getPostId( int catid){
		 System.out.println("daoo");
			System.out.println(catid);
			List<Post> lt=new ArrayList<Post>();
			
			try {
				   String query="select * from posts where catid=?";
				
				   PreparedStatement pstmt=this.con.prepareStatement(query);
					pstmt.setInt(1, catid);
				   
				   ResultSet set = pstmt.executeQuery();
				   while(set.next()) {
					  int pid= set.getInt("pid");
					  String title=set.getString("ptitle");
					  String pcontent=set.getString("pcontent");
					  String pcode=set.getString("pcode");
					  int catidd=set.getInt("catid");
					  int userloginid=set.getInt("userloginid");
					  Post ps=new Post(pid,title,pcontent,pcode,null,catidd,userloginid);
					 
					  lt.add(ps);
				
				   }
			} catch (Exception e) {
				e.printStackTrace();
			}    
			
			return lt;
			
	}
	 
	
}
