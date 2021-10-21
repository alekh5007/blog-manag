<%@page import="com.blog.entities.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.blog.dao.PostDao"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page errorPage="Errorpage.jsp" %>
<%@include file="templates/authenticate.jsp" %>
<%
User u12=(User)session.getAttribute("userdata");
%>

<!doctype html>
<html lang="en">
  <head>
  
<script src="https://code.jquery.com/jquery-3.3.1.js" integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60=" crossorigin="anonymous"></script> 

 
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@include file="templates/css.jsp" %>
   <title>Welcome Blog Managment !!</title>
  </head>
  <body>
  
 <%@include file="templates/homenav.jsp" %>
  


<div class="container">
    <div class="row mt-3">
        <div class="col-md-4">
        <div class="list-group">
  <a href="#" onclick="getpost(0)"  class="list-group-item list-group-item-action catname" aria-current="true">
    All Categories
  </a>
  <%
  Connection con=ConnectionProvider.getConnection();
  PostDao pdd=new PostDao(con);
     ArrayList<Categorie> ls=pdd.getAllCategorie();
     for(Categorie c:ls){
  %>
    <a href="#"  onclick="getpost(<%=c.getCid() %>)" class="list-group-item list-group-item-action catname"><%=c.getName() %> <%=c.getCid() %></a>
  <%
     }
  %>

 
</div>
        </div>
        <div class="col-md-8">
         <%@include file="templates/NewFile.jsp" %>
         <div class="container" id="userdata">
          <h1>Home here  <%=u12.getName() %></h1>
        <h1>Email id:- <%=u12.getEmail() %></h1>
        <h1>user id here  <%=u12.getUserid() %></h1>
       
         </div>
         
         <div class="container" id="postcont">
         
         </div>
       
        </div>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script type="text/javascript">
    
    function getpost(catid){
    	console.log(catid)
    	$.ajax({
    		url:"loaddata.jsp",
    		data:{cid:catid},
    		success:function(data,textStatus,jqXHR){
    			
    			console.log(data);
    			$("#userdata").hide();
    			$("#postcont").html(data);
    			
    		}
    	})
    }
    
    $(document).ready(function(e){
    	
    	$(".catname").click(function(e) {
    		
    	
    	
    	
    	})
    	
    	
    
    	
    	
    })
    </script>
  </body>
</html>