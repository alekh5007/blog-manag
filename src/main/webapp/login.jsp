
<%@include file="templates/authenticate1.jsp" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@include file="templates/css.jsp" %>
   <title>Welcome Blog Managment !!</title>
  </head>
  <body>
  <%@include file="templates/loginnavbar.jsp" %>
    

       <div class="container">
       <div class="row mt-5">
       
           
           
           <div class="col-md-6 offset-3">
               
    <div class="card">
    
    <div class="card-header text-center">
    <h3>Add Contact Here !!</h3>
    </div>
    
  <div class="card-body">
    
  <%@include file="templates/NewFile.jsp" %>
    <form action="CheckUserServlet"  method="post">
   
    
  
  
  
  
    
    <div class="mb-3">
    <label  class="form-label">Email</label>
    <input type="email"  name="email" class="form-control" >
    </div>
    
    <div class="mb-3">
    <label  class="form-label">Password</label>
    <input type="password"  name="password" class="form-control" >
    </div>
    
    
  
  
  <button type="submit" class="btn btn-primary text-center">Submit</button>
  
</form>
  </div>
  </div>
</div>
</div>
    
    
    
    
  </body>
</html>