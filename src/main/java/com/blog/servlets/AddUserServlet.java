package com.blog.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;	
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.UserDao;
import com.blog.entities.Message;
import com.blog.entities.User;
import com.blog.helper.ConnectionProvider;
@WebServlet(name="AddUserServlet",urlPatterns ="/AddUserServlet")
public class AddUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=  req.getParameter("name");
	String email=  req.getParameter("email");
	String password=  req.getParameter("password");
	String address=req.getParameter("address");
	String gender=req.getParameter("age");
	System.out.println(name+":"+email+":"+password+""+address+"age==>"+gender+"");
	
	try {
		
		
		Connection conn=ConnectionProvider.getConnection();
		//System.out.println("conn is@");
		//System.out.println(conn);
		UserDao ud=new UserDao(conn);
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddress(address);
		if(gender.equals("male")) {
			boolean agee=true;
			user.setGender(agee);
			System.out.println("===>male");
		}
		else if(gender.equals("female")) {
			boolean agee=false;
			user.setGender(agee);
			System.out.println(agee);
		}
		else {
			boolean agee=false;
			user.setGender(agee);
			System.out.println("null age");
		}
		
		
		HttpSession hp=req.getSession();
		if(ud.addUser(user)) {
			Message msg=new Message("Succesfully Registered","success");
		hp.setAttribute("msg", msg);
		resp.sendRedirect("signup.jsp");
			
		}else {
			Message msg=new Message("Something went wrong","danger");
			hp.setAttribute("msg", msg);
			resp.sendRedirect("signup.jsp");
				
		}
		//System.out.println(?"added":"something went wromg");
	}
	catch (Exception e) {
		e.printStackTrace();
	}

	
	}

}
