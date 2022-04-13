<%@ page import="com.example.assignmentjspservlet.Model.Categories" %>
<%@ page import="com.example.assignmentjspservlet.Model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/11/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Product p = (Product) request.getAttribute("d");
    List<Categories> list = (List<Categories>)request.getAttribute("l");
%>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<style>
    .imgupload {
        width: 200px;
    }
    .imgupload_hide {
        display: none;
    }
</style>

<body>

<div class="w3-container w3-blue">
    <h2>Sửa</h2>
</div>

<form class="w3-container" action="/AssignmentJSPServlet_war_exploded/admin/updateproducts" method="post" name="From_Create">
    <input class="w3-input" type="hidden" name="Id" value="<%=p.getId()%>"></p>
    <input class="w3-input" type="hidden" name="Status" value="<%=p.getStatus()%>"></p>
    <input class="w3-input" type="hidden" name="CreateAt" value="<%=p.getCreatedAt()%>"></p>
    <p>
        <label>Tên</label>
        <input class="w3-input" type="text" name="Name" value="<%=p.getName()%>"></p>
    <p>
    <p>
        <label>Giá </label>
        <input class="w3-input" type="text" name="Price" value="<%=p.getPrice()%>"></p>
    <p>
    <p>
        <label>Nội dung</label>
        <input class="w3-input" type="text" name="Content" value="<%=p.getContent()%>"></p>
    <p>
    <p>
        <label>Tên</label>
    <div class="custom-select" style="width:200px;">
        <select name="idcate">
            <%
                for (int i = 0; i < list.size(); i++) {
                    Categories obj = list.get(i);
                    if (obj.getId() == p.getIdCategories()){
            %>
            <option selected value="<%=obj.getId()%>"><%=obj.getName()%></option>
                <%
                    }else {
                %>
            <option value="<%=obj.getId()%>"><%=obj.getName()%></option>
            <%
                    }
                }
            %>
        </select>
    </div>
    <p>
        <label>Hình ảnh</label>
        <img src="<%=p.getImg()%>" class="w3-round" alt="Norway" id="image_update">
        <img src="<%=p.getImg()%>" class="w3-round imgupload_hide" alt="Norway" id="image_preview" >
        <button type="button" id="upload_widget" class="cloudinary-button" style="background-color: green">Upload files</button>
        <input class="w3-input" type="hidden" name="img"></p>
    <p><button class="w3-button w3-light-green" type="submit">Thêm</button></p>
</form>
</div>


<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

<script type="text/javascript">
    var myWidget = cloudinary.createUploadWidget({
            cloudName: 'dcy8k4pqx',
            uploadPreset: 'zk3oepjj'}, (error, result) => {
            if (!error && result && result.event === "success") {
                console.log('Done! Here is the image info: ', result.info.url);
                var img = document.getElementById("image_preview");
                img.classList.remove("imgupload_hide");
                img.src = result.info.url;
                var img1 = document.getElementById("image_update");
                img1.classList.add("imgupload_hide");
                document.forms['From_Create']['img'].value = result.info.url;
            }
        }
    )

    document.getElementById("upload_widget").addEventListener("click", function(){
        myWidget.open();
    }, false);
</script>
</body>
</html>
