<%@ page import="com.example.assignmentjspservlet.Model.Categories" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.assignmentjspservlet.Model.Product" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2022
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<Product> list = (List<Product>)request.getAttribute("l");
  String t = "1";
%>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<body>

<div class="w3-container">
  <nav class="navbar navbar-expand-sm bg-light navbar-light" style="height: 90px">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/admin"><img src="https://freedesignfile.com/upload/2017/12/Health-food-logo-vector.jpg" style="height: 100px"></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/admin/categories">Danh mục sản phẩm</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/AssignmentJSPServlet_war_exploded/admin/listproducts">Sản phẩm</a>
      </li>
    </ul>
  </nav>
  <h2>Sản phẩm</h2>
  <a href="/AssignmentJSPServlet_war_exploded/admin"><p><button class="w3-button w3-block w3-teal">Quay lại</button></p></a>
  <a href="/AssignmentJSPServlet_war_exploded/admin/createproducts"><p><button class="w3-button w3-block w3-teal">Thêm mới</button></p></a>
  <table class="w3-table-all">
    <thead>
    <tr class="w3-red">
      <th>Tên</th>
      <th>Hình ảnh</th>
      <th>Mã danh mục</th>
      <th>Giá</th>
    </tr>
    </thead>
    <%
      for (int i = 0; i < list.size(); i++) {
        Product obj = list.get(i);
    %>

    <tr>
      <td><%=obj.getName()%></td>
      <td><img src="<%=obj.getImg()%>" style="width: 100px "></td>
      <td><%=obj.getIdCategories()%></td>
      <td><%=obj.getPrice()%></td>
      <td><a href="/AssignmentJSPServlet_war_exploded/admin/detailproduct?id=<%=obj.getId()%>">Chi tiết</a></td>
      <td><a href="/AssignmentJSPServlet_war_exploded/admin/updateproducts?id=<%=obj.getId()%>">Sửa</a></td>
      <td><a href="/AssignmentJSPServlet_war_exploded/admin/deleteproduct?id=<%=obj.getId()%>" class="btndelete">Xóa</a></td>
    </tr>

    <%
      }
    %>
  </table>
</div>
</body>
</html>
