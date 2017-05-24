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
    <script>
        $(document).ready(function(){
            $(".add").click(function(){
                var buy_goods_num=$(this).parent().find('input[class*=num]');
                var price=$(this).parent().parent().find('td[class*=price]');
                var sum=$(this).parent().parent().find('td[class*=sum]');
                buy_goods_num.val(parseInt(buy_goods_num.val())+1);
                sum.html(parseInt(buy_goods_num.val())*parseInt(price.html()));
            });

            $(".minus").click(function(){
                var buy_goods_num=$(this).parent().find('input[class*=num]');
                var price=$(this).parent().parent().find('td[class*=price]');
                var sum=$(this).parent().parent().find('td[class*=sum]');
                if(buy_goods_num.val()>0)buy_goods_num.val(parseInt(buy_goods_num.val())-1);
                sum.html(parseInt(buy_goods_num.val())*parseInt(price.html()));

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
            <li><a href="updateGoods.do">添加</a></li>
            <li><a href="myGoods.do">我的仓库</a></li>
            <li><a href="myOrder.do">我的订单</a></li>
            <li><a href="itOrder.do">他人订单</a></li>
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
                <td colspan="8"> 卖家：<a href="">${item.customer}</a></td>
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
                    <input type="button" class="minus"  value="-">
                    <input type="text" class="num" value="0">
                    <input type="button" class="add" value="+">
                </td>
                <td class="sum">0</td>
                <td>
                    <a href="deleteGoods.do?id=${item.id}">下架</a>|<a href="comment.do?id=${item.id}">评论</a>
                </td>
            </tr>
        </c:forEach>




        </tbody>
    </table>

</div>
</body>
</html>

