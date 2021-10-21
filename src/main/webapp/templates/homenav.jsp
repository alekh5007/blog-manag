<%@page import="com.blog.entities.User"%>
<%@page import="com.blog.entities.Categorie"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.blog.dao.PostDao"%>
<%@page import="com.blog.helper.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%
User u1=(User)session.getAttribute("userdata");
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Welcome to Blog Managment <%=u1.getName() %></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#" data-toggle="modal" data-target="#postModal">Add Post <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item active">
       
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
       <a href="#!important"class="btn btn-outline-success my-2 my-sm-0" data-toggle="modal" data-target="#editModal">Profile</a>
       
        
      <a href="LogoutServlet"class="btn btn-outline-success my-2 my-sm-0" type="submit">Logout</a>
    </form>
  </div>
</nav>






<!-- Edit Modal -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Welcome to Blog Managment</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
        <div class="container">
        <div class="profiledetails">
       
          <table class="table">
  
  <tbody>
   <tr>
      <th scope="row">ID</th>
      <td><%=u1.getUserid() %></td>
      
    </tr>
    
    <tr>
      <th scope="row">Name</th>
      <td><%=u1.getName() %></td>
      
    </tr>
    <tr>
      <th scope="row">Email</th>
      <td><%=u1.getEmail() %></td>
      
    </tr>
    <tr>
      <th scope="row">Password</th>
      <td><%=u1.getPassword()%></td>
      
    </tr>
    
     <tr>
      <th scope="row">Address</th>
      <td><%=u1.getAddress() %></td>
      
    </tr>
    
  </tbody>
</table>
 
        </div>
        
        <div class="editdetails" style="display:none">
        <h3 class="mt-2">Please Edit Carefully</h3>
        <form action="Editservlet" method="post">
        <table class="table">
        <tr>
        <td>ID</td>
        <td><%=u1.getUserid() %></td>
        </tr>
        
          <tr>
        <td>Email</td>
        <td><input type="email" name="useremail" value="<%=u1.getEmail() %>" class="form-control"></td>
        </tr>
        
          <tr>
        <td>Name</td>
        <td><input type="text" name="username" value="<%=u1.getName() %>" class="form-control"></td>
        </tr>
        
          <tr>
        <td>Password</td>
        <td><input type="password" name="userpassword" value="<%=u1.getPassword() %>" class="form-control"></td>
        </tr>
        
         <tr>
        <td>Address</td>
        <td><input type="text" name="useraddress" value="<%=u1.getAddress() %>" class="form-control"></td>
        </tr>
        
        
        
        </table>
        
        <div class="container">
             <button type="submit" class="btn btn-outline-primary">Save</button>
        </div>
        
        
        </form>
        </div>
        
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" id="edit" class="btn btn-primary">Edit</button>
      </div>
    </div>
  </div>
</div>

<!-- End Edit Modal -->

<!-- Post Modal -->

<!-- Button trigger modal -->


<!-- Modal -->
<div class="modal fade" id="postModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Provide the Post Details..</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        
        <form action="PostServlet" method="post">
        
             <div class="form-group">
                 <select class="form-control"  name="catid">
                     
                     <%
                     Connection cs=ConnectionProvider.getConnection();
                     PostDao pd=new PostDao(cs);
                    ArrayList<Categorie>list= pd.getAllCategorie();
                    for(Categorie c:list){
                     %>
                     <option value="<%=c.getCid() %>"><%=c.getName() %></option>
                     <%
                    }
                     %>
                 </select>
             </div>
        
             <div class="form-group">
                <input type="text" class="form-control" placeholder="Enter Your title" name="ptitle">
             </div>
             
             <div class="form-group">
                  <textarea class="form-control" style="height:150px;" placeholder="Enter Your Content" name="pcont"></textarea>   
             </div>
             
              <div class="form-group">
                  <textarea class="form-control" style="height:150px;" placeholder="Enter Your Program" name="pcode"></textarea>   
             </div>
             
             <div class="container">
             <button type="submit" class="btn btn-outline-primary">Save</button>
        </div>
        
        </form>
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

<!-- End post Modal -->

<script>
$(document).ready(function(){
	let status=false;
	
	$('#edit').click(function(){
		if(status==false){
			$('.profiledetails').hide();
			$('.editdetails').show();
			$(this).text("Back")
			status=true;
		}
		else{
			$('.profiledetails').show();
			$('.editdetails').hide();
			$(this).text("Edit")
			status=false;
		}
	
	});
});
</script>
</body>
</html>