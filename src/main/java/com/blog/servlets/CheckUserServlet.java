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
@WebServlet(name="CheckUserServlet",urlPatterns = "/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
		String email= req.getParameter("email");
		String password=req.getParameter("password");
		System.out.println(":"+email+":"+password+"");
		
		try {
			
			
			Connection conn=ConnectionProvider.getConnection();
			
			UserDao ud=new UserDao(conn);
			
			User us=ud.getEmailAndPassword(email,password);
			
			HttpSession hp=req.getSession();
			if(us!=null) {
				hp.setAttribute("userdata", us);
				
			resp.sendRedirect("home.jsp");
				
			}else {
				Message msg=new Message("Something went wrong","danger");
				hp.setAttribute("msg", msg);
				resp.sendRedirect("login.jsp");
					
			}
			//System.out.println(?"added":"something went wromg");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
