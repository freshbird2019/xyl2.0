<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/24
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>manager</title>
</head>
<body>
<h2>管理员登陆</h2>
<form:form method = "POST" action = "checkLogin">
    <table>
        <tr>
            <td><form:label path = "id">id</form:label></td>
            <td><form:input path = "id"></form:input></td>
        </tr>
        <tr>
            <td><form:label path = "name">User Name</form:label></td>
            <td><form:input path = "name" /></td>
        </tr>
        <tr>
            <td><form:label path = "password">Password</form:label></td>
            <td><form:password path = "password" /></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
        <tr>
            ${msg}
        </tr>
    </table>
</form:form>
</body>
</html>