<%@page import="com.blog.entities.User"%>
<%@page import="com.blog.entities.Message"%>
<% 
User user1=(User)session.getAttribute("userdata");
if(user1!=null){

	response.sendRedirect("home.jsp");
	return;
}

%>