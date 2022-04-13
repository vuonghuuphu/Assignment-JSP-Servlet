<%@ page import="com.example.assignmentjspservlet.Model.Categories" %>
<%@ page import="com.example.assignmentjspservlet.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/11/2022
  Time: 1:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    Product p = (Product) request.getAttribute("detail");
%>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chi tiết</h2>
<h3><%=p.getName()%></h3>
<h3><%=p.getPrice()%></h3>
<h3><%=p.getContent()%></h3>
<h3><%=p.getIdCategories()%></h3>
<h3><%=p.getCreatedAt()%></h3>
<img src="<%=p.getImg()%>" style="width: 150px">
</body>
</html>
