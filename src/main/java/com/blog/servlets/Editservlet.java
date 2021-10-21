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
@WebServlet(name="Editservlet",urlPatterns = "/Editservlet")
public class Editservlet extends HttpServlet {

	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=  req.getParameter("username");
		String email=  req.getParameter("useremail");
		String password=  req.getParameter("userpassword");
		String address=req.getParameter("useraddress");

		System.out.println(name+""+email+":"+password+":"+address+"updated data");
		
		try {
	        Connection conn=ConnectionProvider.getConnection();
			UserDao us=new UserDao(conn);
			
			HttpSession hs=req.getSession();
			User ud = (User)hs.getAttribute("userdata");
			ud.setName(name);
			ud.setEmail(email);
			ud.setPassword(password);
			ud.setAddress(address);
			
		    boolean isedited=us.updateuser(ud);
		    HttpSession hpp=req.getSession();
		    if(isedited) {
		    	System.out.println("data updated .. alekh");
		    	Message msg=new Message("your Profile data updated","success");
				hpp.setAttribute("msg", msg);
				resp.sendRedirect("home.jsp");
		    }
		    else {
		    	System.out.println("data Not updated .. alekh");
		    	Message msg=new Message("Something went wrong","danger");
				hpp.setAttribute("msg", msg);
				resp.sendRedirect("home.jsp");
		    }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
