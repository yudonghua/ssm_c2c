<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>登录</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <script type="text/javascript">
        function change() {
            var img = document.getElementById("verify");
            img.src = "VerifyCodeServlet.do?a=" + new Date().getTime();
        }
    </script>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/demo.css">
    <link rel="stylesheet" type="text/css" href="css/form.css">
</head>

<body>
<center>
    <div>
        <div class="demo" style="padding: 20px 0;">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-3 col-md-6">
                        <form action="loginServlet.do" method="post" class="form-horizontal form-style">
                            <span class="heading">用户登录</span>
                            <div class="form-group">
                                <input type="text" class="form-control" id="inputEmail3" name="username"
                                       value="${username}" placeholder="请输入账号">

                                <i class="fa fa-user"></i>
                            </div>
                            <div class="form-group help">
                                <input type="password" class="form-control" id="inputPassword3" name="password"
                                       value="${password}" placeholder="请输入密码">
                                <i class="fa fa-lock"></i>
                                <!--<a href="#" class="fa fa-question-circle"></a>-->
                            </div>
                            <div class="form-group help">
                                <input type="text" class="form-ve" name="verifycode" placeholder="验证码"
                                       style="float:left">
                                <%--<font color="red" size="2" style="line-height:40px">${msg}</font>--%>
                                <a href="javascript:change()" style="float:right">
                                    <img src="VerifyCodeServlet.do" width="200" height="40" id="verify" border="0"/>
                                </a>

                                <!--						<i class="fa fa-lock"></i>-->
                                <!--<a href="#" class="fa fa-question-circle"></a>-->
                            </div>
                            <div class="form-group">
                                <div class="main-checkbox">
                                    <input type="checkbox" value="None" id="checkbox1" name="check">
                                    <label for="checkbox1"></label>
                                </div>
                                <span class="text">记住密码</span>
                                <input type="submit" class="btn btn-default" value="登录"/>
                            </div>
                            <div class="form-group" >
                                <font color="red" size="2" style="line-height:40px">${msg}</font>
                            </div>


                        </form>
                    </div>
                </div>
            </div>
        </div>
        <center><a href="Regist.do" style="visibility: visible"><font size="2">没有帐号？点击注册</font></a></center>

    </div>
</center>
</body>
</html>