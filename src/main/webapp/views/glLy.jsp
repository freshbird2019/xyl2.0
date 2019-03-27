<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/27
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>管理留言</title>
</head>
<body>
<form action="#" method="get">
    <table border="1">
        <tr>
            <th>主题</th>
            <th>时间</th>
            <th>地点</th>
            <th>人数限制</th>
            <th>内容</th>
        </tr>
        <c:forEach var="acItem" items="${activities}">
            <tr>
                <td>
                    <input type="checkbox" name="id" value="${acItem.name}"/>
                </td>
                <td>${acItem.time}</td>
                <td>${acItem.location}</td>
                <td>${acItem.num}</td>
                <td>${acItem.description}</td>
                <td>
                    <a href="deleteAc.do?id=${acItem.aid}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addAc.do">添加</a>
</form>

</body>
</html>
