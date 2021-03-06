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
            <li><a href="myData.do">信息修改</a></li>
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
            <td>邮寄地址</td>
            <td>数量</td>
            <td>货物状态</td>
            <td>操作</td>
        </tr>


        <c:forEach var="item" items="${order}">
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
            <tr class="customer">
                <td colspan="8"> 买家：<a href="listGoods.do?customer=${item.customer}">${item.customer}</a></td>
            </tr>
            <tr>
                <td colspan="8" class="line"></td>
            </tr>
            <tr class="shopping goods">

                <td><img src="images/goods/${item.gid}.png" class="img" alt="shopping"></td>
                <td colspan="3"><br>
                        ${item.name}<br>
                </td>
                <td class="price">${item.address}</td>
                <td class="cnum">
                    <input type="text" class="num" value="${item.num}">
                </td>
                <td class="sum">${item.status}</td>
                <td>
                    <a href="changeStatus.do?id=${item.id}&jsp=itOrder">发货</a>|<a href="comment.do?id=${item.gid}">评论</a>
                </td>
            </tr>
        </c:forEach>




        </tbody>
    </table>

</div>
</body>
</html>

