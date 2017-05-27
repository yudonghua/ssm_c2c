<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html>
<head>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" rel="stylesheet" href="css/test.css"/>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery.min.js" language="JavaScript"></script>
    <script src="js/bootstrap.min.js" language="JavaScript"></script>
    <script>
        $(document).ready(function(){
            var gid;
            $(".add").click(function(){
                var buy_goods_num=$(this).parent().parent().find('input[class*=num]');
                var price=$(this).parent().parent().parent().find('td[class*=price]');
                var sum=$(this).parent().parent().parent().find('td[class*=sum]');
                buy_goods_num.val(parseInt(buy_goods_num.val())+1);
                sum.html(parseInt(buy_goods_num.val())*parseInt(price.html()));
            });

            $(".minus").click(function(){
                var buy_goods_num=$(this).parent().parent().find('input[class*=num]');
                var price=$(this).parent().parent().parent().find('td[class*=price]');
                var sum=$(this).parent().parent().parent().find('td[class*=sum]');
                if(buy_goods_num.val()>0)buy_goods_num.val(parseInt(buy_goods_num.val())-1);
                sum.html(parseInt(buy_goods_num.val())*parseInt(price.html()));

            });
            $(".buy").click(function(){
                gid=$(this).parent().find('input[class*=gid]').val();

            });
            $(".delete").click(function(){
                var password=$(this).parent().parent().find('.form-control').val()
                location.href = "delete.do?id="+gid+"&password="+password;

            });
        });


    </script>
</head>
<body>
<div id="header">
    <ul>shoping</ul>
</div>
<div id="content">
    <div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="listGoods.do">商城</a></li>
            <li><a href="">管理员页面</a></li>
        </ul>
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" >
        <tbody>
        <tr>
            <td colspan="8" class="line"></td>
        </tr>
        <tr style="text-align: center">
            <td  colspan="4">
                <form action="listGoods.do" style="margin: 0px auto">
                    <input type="text" name="name"/>
                    <input type="submit" class="btn btn-info" value="搜索"/>
                </form>
            </td>
            <td>单价（元）</td>
            <td>数量</td>
            <td>小计（元）</td>
            <td>操作</td>
        </tr>


        <c:forEach var="item" items="${goods}">
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
            <tr class="customer">
                <td colspan="8"> 卖家：<a href="listGoods.do?customer=${item.customer}">${item.customer}</a></td>
            </tr>
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
            <tr class="shopping goods">
                <td><img src="images/goods/${item.id}.png" class="img" alt="shopping"></td>
                <td colspan="3">${item.name}<br>
                        ${item.type}<br>
                        ${item.introduce}</td>
                <td class="price">${item.price}</td>
                <td class="cnum">
                    <input type="text" class="num" name="num" value="0">
                </td>
                <td class="sum">0</td>
                <td>
                    <input class="gid" value="${item.id}" style="display: none"/>
                    <input type="button" class="buy" data-toggle="modal" data-target="#myModal" value="下架">|<a href="comment.do?id=${item.id}">评论</a>
                </td>
            </tr>
        </c:forEach>




        </tbody>
    </table>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        请输入管理员密码
                    </h4>
                </div>
                <div class="modal-body">
                    <input type="password" class="form-control" placeholder="twitterhandle">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">
                        关闭
                    </button>
                    <button type="button" class="btn btn-primary delete">
                        确认下架
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>

