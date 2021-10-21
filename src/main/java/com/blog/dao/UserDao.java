package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.blog.entities.User;

public class UserDao {

	Connection con;

	public UserDao(Connection con) {
		
		this.con = con;
	}
	
	public boolean addUser(User us) {
		boolean flag=false;
		try {
			
			
			
			String query="insert into user(name,email,password,address,gender) values(?,?,?,?,?)";
			PreparedStatement pstmt=this.con.prepareStatement(query);
			pstmt.setString(1, us.getName());
			pstmt.setString(2, us.getEmail());
			pstmt.setString(3, us.getPassword());
			pstmt.setString(4, us.getAddress());
			pstmt.setBoolean(5, us.getGender());
			int row=pstmt.executeUpdate();
			System.out.println("Contact added");
			flag =true;
			//return flag;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	//get User by email and password
		public User getEmailAndPassword(String email,String password) {
			User user=null;
			
			try {
				
				String query="select * from user where email =? and password =?";
				PreparedStatement pstmt=this.con.prepareStatement(query);
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				ResultSet set =pstmt.executeQuery();
				if(set.next()) {
					user=new User();
					user.setUserid(set.getInt("userid"));
					user.setName(set.getString("name"));
					user.setEmail(set.getString("email"));
					user.setPassword(set.getString("password"));
					user.setAddress(set.getString("address"));
					user.setGender(set.getBoolean("gender"));
					
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return user;
		}
		
		//update user

		public boolean updateuser(User us) {
			boolean flag=false;
			
			try {
				String query="update user set name=?,email=?,password=?,address=? where userid=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, us.getName());
				pstmt.setString(2, us.getEmail());
				pstmt.setString(3, us.getPassword());
				pstmt.setString(4, us.getAddress());
				pstmt.setInt(5, us.getUserid());
			
				int row=pstmt.executeUpdate();
				
				flag =true;
				
				
				
				//return flag;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return flag;
		}
		
	
}
