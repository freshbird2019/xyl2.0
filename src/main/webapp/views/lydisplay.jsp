<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/18
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言信息查看</title>
</head>
<body>
<form action="#" method="post">
    <table border="1">
        <tr>
            <th>id</th>
            <th>time</th>
            <th>username</th>
            <th>info</th>
            <th>todo</th>
        </tr>
        <c:forEach var="ly" items="${lys}">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${ly.lyId}"/>
                </td>
                <td>${ly.lyDate}</td>
                <td>${ly.lyLyr}</td>
                <td>${ly.lyInfo}</td>
                <td>
                    <a href="delete.do?id=${ly.lyId}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addLy.do">添加</a>
    </form>
</body>
</html>
