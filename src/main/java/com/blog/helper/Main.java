package com.blog.helper;

import java.sql.Connection;

import com.blog.dao.UserDao;
import com.blog.entities.User;

public class Main {

	public static void main(String args[]) {
		try {
			//Connection conn=ConnectionProvider.getConnection();
			//System.out.println("conn is@");
			//System.out.println(conn);
			//UserDao ud=new UserDao(conn);
			
			User user=new User();
			user.setName("alekh");
			user.setEmail("alekhroy111@gmail.com");
			user.setPassword("password@1234");
			user.setAddress("Bokaro");
			user.setGender(false);
			
			//ud.addUser(user);
			//System.out.println(ud.addUser(user)?"added":"something went wromg");
		}
		catch (Exception e) {
			e.printStackTrace();
		}


	}
}
