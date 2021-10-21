package com.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.entities.Message;
@WebServlet(name="LogoutServlet",urlPatterns = "/LogoutServlet")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session=req.getSession();
		session.removeAttribute("userdata");
		Message msg=new Message("Logout Succesfully..","danger");
		session.setAttribute("msg", msg);
		resp.sendRedirect("login.jsp");
		
	}
   
	
}
