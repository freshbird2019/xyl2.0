<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/28
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>申请加入班级</title>
</head>
<body>
<form action="#" method="post">
    <table border="1">
    <tr>
        <th>Name</th>
        <th>Year</th>
        <th>Major</th>
        <th>College</th>
        <th>todo</th>
    </tr>
    <c:forEach var="oneclass" items="${clazz}">
        <tr>
            <td>${oneclass.name}</td>
            <td>${oneclass.year}</td>
            <td>${oneclass.major}</td>
            <td>${oneclass.college}</td>
            <td><a href="applyClass.do?xid=${nowinxy.xid}&&cid=${oneclass.cid}">申请</a></td>
        </tr>
    </c:forEach>
    </table>
</form>
</body>
</html>
