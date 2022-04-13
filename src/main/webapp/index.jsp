<%@ page import="com.example.assignmentjspservlet.Model.Account" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Account account = (Account)session.getAttribute("currentAccount");
    boolean islogin = false;
    if (account != null){
        islogin = true;
    }
    String name = account == null ? "Guest" : account.getUsername();
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<%
if (islogin){
%>
<p><%=name%><a href="/AssignmentJSPServlet_war_exploded/"></a></p>
<%}else{%>
<a href="/AssignmentJSPServlet_war_exploded/Food/Login">
    Login
</a>
<a href="/AssignmentJSPServlet_war_exploded/Food/Register">
    Register
</a>
<%}%>
</body>
</html>