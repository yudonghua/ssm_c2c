<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>


    <title>添加商品</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
    <script src="js/uploadPreview.js" type="text/javascript"></script>
    <script src="js/uploadPreview.min.js" type="text/javascript"></script>
    <script src="jquery-1.7.1.min.js" type="text/javascript"></script>
    <script>
        window.onload = function () {
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
            new uploadPreview({ UpBtn: "up_user_img", DivShow: "user_img", ImgShow: "user_imgShow" });
        }
    </script>


</head>

<body>
<div class="demo" style="padding: 20px 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form action="addGoods.do" method="post" enctype="multipart/form-data" class="form-horizontal form-style">
                    <span class="heading">添加商品</span>
                    <input  id="up_img" style="display:none" type="file" name="img" class="file"/>
                    <div id="imgdiv" onclick="select()">
                        <img src="images/add.png" id="imgShow" width="100" height="100" />
                    </div>
                    <br>
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputEmail3" name="name"  placeholder="商品名字" style="float:left" placeholder="请输入账号">
                        <i class="fa fa-cog fa-spin"></i>
                    </div>
                    <div class="form-group help">
                        <input type="text" class="form-control" id="inputPassword3" name="type"  placeholder="商品种类" placeholder="请输入密码">
                        <i class="fa fa-cog fa-spin"></i>
                    </div>
                    <div class="form-group help" >
                        <input type="text" class="form-control" name="introduce" placeholder="商品介绍" style="float:left">
                        <i class="fa fa-cog fa-spin"></i>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="price"  value="" style="float:left" placeholder="商品价钱">
                        <i class="fa fa-cog fa-spin"></i>
                    </div>

                    <div class="form-group" >
                        <button type="submit" class="btn btn-default">添加</button>
                    </div>
                    <div class="form-group" >
                        <div>${msg}</div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function select(){
        $("#up_img").click();
    }
</script>
</body>
</html>
