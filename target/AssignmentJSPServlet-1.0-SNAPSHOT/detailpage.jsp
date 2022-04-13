<%@ page import="com.example.assignmentjspservlet.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/12/2022
  Time: 8:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product p = (Product)request.getAttribute("detail");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-light navbar-light" style="height: 90px">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/food/homepage"><img src="https://freedesignfile.com/upload/2017/12/Health-food-logo-vector.jpg" style="height: 100px"></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/food/homepage">Trang chủ</a>
        </li>
        <li class="nav-item active">
            <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/food/productpage">Sản phẩm</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/food/cartpage">Giỏ hàng</a>
        </li>
    </ul>
</nav>

<div class="container">
    <div>
<div class="row">
    <div class="col-md-4">
        <img src="<%=p.getImg()%>" style="width: 200px">
    </div>
    <div class="col-md-4">
        <p><%=p.getName()%></p>
        <p><%=p.getPrice()%></p>
    </div>
    <div class="col-md-4">
        <div><a href="/AssignmentJSPServlet_war_exploded/admin/updatecategories?id=<%=p.getId()%>" style="margin: 5px">
            <button type="button" class="btn btn-success">Thêm vào giỏ hàng</button>
        </a></div>
    </div>
</div>
    </div>
</div>

</body>
</html>
