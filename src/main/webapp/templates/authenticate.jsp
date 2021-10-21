<%@page import="com.blog.entities.User"%>
<%@page import="com.blog.entities.Message"%>
<% 
User user1=(User)session.getAttribute("userdata");
if(user1==null){
	Message ms=new Message("you are not logged in !!", "danger");
	session.setAttribute("msg", ms);
	response.sendRedirect("login.jsp");
	return;
}

%>