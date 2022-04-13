<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/6/2022
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Đăng nhập</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2>Đăng nhập</h2>
    <form action="/AssignmentJSPServlet_war_exploded/Food/Login" method="post">
        <div class="form-group">
            <label for="username">Tài khoản:</label>
            <input type="text" class="form-control" id="username" placeholder="Nhập tên tài khoản" name="username">
        </div>
        <div class="form-group">
            <label for="pass">Mật khẩu:</label>
            <input type="password" class="form-control" id="pass" placeholder="Nhập mật khẩu" name="pass">
        </div>

        <button type="submit" class="btn btn-primary">Đăng nhập</button>
        <div>
            <a href="/AssignmentJSPServlet_war_exploded/Food/Register">Tôi chưa có tài khoản </a>
        </div>
    </form>
</div>

</body>
</html>
