<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.3b1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.dataTables.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.tablesorter.js"></script>
    <script>
        function searchWine() {
            window.location.href="searchWine.do?name="+$("#name").val();
        }
    </script>
    <title>ListWine</title>
</head>
<body onload="fillTable();">
<h2>
    五粮液
</h2>
<hr size="20" color="yellow">
<div>

    <c:choose>
        <c:when test="${empty wines}">
            尚无酒，请添加！
        </c:when>
        <c:otherwise>
            <table cellpadding="5" cellspacing="0" border="1" class="display"
                   id="myTable" align="center" style="background: #ffffcc">
                <thead>
                <tr align="center">
                    <th></th>
                    <th><input type="text" id="name" name="name"/></th>
                    <th><input type="button"  value="查询" onclick="searchWine()"/></th>
                </tr>
                <tr align="center">
                    <th>ID</th>
                    <th>酒名</th>
                    <th>香型</th>
                    <th>原材料</th>
                    <th>净含量</th>
                    <th>酒精度</th>
                    <th>介绍</th>
                </tr>
                </thead>
                <tbody align="center">
                <c:forEach var="wine" items="${wines}" varStatus="count">
                    <tr>

                        <td>${wine.wid}</td>
                        <td>${wine.name}</td>
                        <td>${wine.flavor}</td>
                        <td>${wine.raw}</td>
                        <td>${wine.netv}</td>
                        <td>${wine.vol}</td>
                        <td>${wine.introduce}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/deleteWine.do?wid=${wine.wid}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                <form action="addWine.do" method="post">
                    <tr>

                        <td></td>
                        <td><input type="text" name="name"/></td>
                        <td><input type="text" name="flavor"/></td>
                        <td><input type="text" name="raw"/></td>
                        <td><input type="text" name="netv"/></td>
                        <td><input type="text" name="vol"/></td>
                        <td><input type="text" name="introduce"/></td>
                        <td>
                            <input type="submit" value="添加">
                        </td>
                    </tr>
                </form>

                </tbody>
            </table>

        </c:otherwise>
    </c:choose>
</div>
</body>
</html>