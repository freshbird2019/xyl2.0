<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/18
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xyinfo</title>
</head>
<body>
<form action="#" method="post">
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Age</th>
            <th>Sex</th>
            <th>Phone</th>
            <th>Email</th>
            <th>todo</th>
        </tr>
        <c:forEach var="xy" items="${xys}">
            <tr>
                <td>${xy.xyId}</td>
                <td>${xy.xyUsername}</td>
                <td>${xy.xyAge}</td>
                <td>${xy.xySex}</td>
                <td>${xy.xyPhone}</td>
                <td>${xy.xyEmail}</td>
                <td><a href="updateXyEntity.do?id=${xy.xyId}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
