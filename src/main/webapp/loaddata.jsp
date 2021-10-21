<%@page import="com.blog.entities.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.blog.dao.PostDao"%>

<div class="row">


<%
Connection con=ConnectionProvider.getConnection();
   PostDao d=new PostDao(con);
   List<Post>lp=null;
   int catid=Integer.parseInt(request.getParameter("cid"));
   
  // System.out.print(catid);
   if(catid==0){
	  lp=d.getAllpost(); 
   }else{
	   lp=d.getPostId(catid);
   }
 
   
 
   
   for(Post p:lp){
	   
%>
<div class="col-md-6">
     <div class="card" >
       <img src="https://content.techgig.com/thumb/msid-79110796,width-860,resizemode-4/5-Strongest-reasons-for-non-programmers-to-learn-coding.jpg" class="card-img-top" alt="...">
        <div class="card-body">
        <b><%=p.getPtitle() %></b>
        <p><%=p.getPcontent() %></p>
        </div>
     </div>
</div>

<%
   }
%>

</div>