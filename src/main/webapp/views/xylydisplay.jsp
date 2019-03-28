<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/28
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校友查看留言</title>
</head>
<body>
<form action="#" method="post">
    <table border="1">
        <tr>
            <th>time</th>
            <th>username</th>
            <th>info</th>
        </tr>
        <c:forEach var="ly" items="${lys}">
            <tr>
                <td>${ly.lydate}</td>
                <td>null</td>
                <td>${ly.info}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="addLy.do?id=${nowinxy.xid}">添加</a>
</form>
</body>
</html>

