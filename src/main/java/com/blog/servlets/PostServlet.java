package com.blog.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blog.dao.PostDao;
import com.blog.entities.Message;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.helper.ConnectionProvider;
@WebServlet(name="PostServlet",urlPatterns ="/PostServlet")
public class PostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int catid=Integer.parseInt(req.getParameter("catid"));
		System.out.println(catid);
		String ptitle=req.getParameter("ptitle");
		String pcontent=req.getParameter("pcont");
		String code=req.getParameter("pcode");
		System.out.println(ptitle+":"+pcontent+""+code+"");
		
		
		
		HttpSession session=req.getSession();
		User u=(User) session.getAttribute("userdata");
		System.out.println(ptitle+":"+pcontent+""+code+":"+catid+"");
		
		Post post=new Post(ptitle,pcontent,code,null,catid,u.getUserid());		
		Connection conn=ConnectionProvider.getConnection();
		PostDao pd=new PostDao(conn);
		boolean f=pd.postdata(post);
		HttpSession hpp=req.getSession();
		if(f) {
			Message msg=new Message("your Post added","success");
			hpp.setAttribute("msg", msg);
			resp.sendRedirect("home.jsp");
			System.out.println("post added");
		}else {
			Message msg=new Message("Something went wrong","danger");
			hpp.setAttribute("msg", msg);
			resp.sendRedirect("home.jsp");
			System.out.println("something went wrong");
		}
	}

	

	

}
