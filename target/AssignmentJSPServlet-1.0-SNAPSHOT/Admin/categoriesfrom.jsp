<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/9/2022
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2>Thêm mới</h2>
</div>

<form class="w3-container" action="/AssignmentJSPServlet_war_exploded/admin/From" method="post" name="From_Create">
    <p>
        <label>Tên danh mục</label>
        <input class="w3-input" type="text" name="Name"></p>
    <p>
        <label>Hình ảnh</label>
        <img style="" src="img_snowtops.jpg" class="w3-round imgupload_hide" alt="Norway" id="image_preview" >
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