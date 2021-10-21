
<%@page import="com.blog.entities.Message"%>
<%
Message msgg=(Message) session.getAttribute("msg");
if(msgg !=null){
%>

<div class="alert alert-<%=msgg.getMsgType() %>" role="alert">
  <%=msgg.getMsgcontent() %>
</div>
<%
session.removeAttribute("msg");
}

%>