<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


    <title>注册</title>

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

</head>

<body>
<div class="demo" style="padding: 20px 0;">
    <div class="container">
        <div class="row">
            <div class="col-md-offset-3 col-md-6">
                <form action="registServlet.do" method="post" class="form-horizontal form-style">
                    <span class="heading">用户注册</span>
                    <div class="form-group">
                        <input type="text" class="form-control" id="inputEmail3" name="username"  value="${username}" style="float:left" placeholder="请输入账号">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group help">
                        <input type="password" class="form-control" id="inputPassword3" name="password"  value="${password}" placeholder="请输入密码">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group help" >
                        <input type="password" class="form-control" name="rpsw" placeholder="请确认密码" style="float:left">
                        <i class="fa fa-lock"></i>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="phone"  value="" style="float:left" placeholder="电话号码">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" name="address"  value="" style="float:left" placeholder="住址">
                        <i class="fa fa-user"></i>
                    </div>
                    <div class="form-group" >
                        <button type="submit" class="btn btn-default">注册</button>
                    </div>
                    <div class="form-group" >
                        <div>${msg}</div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
