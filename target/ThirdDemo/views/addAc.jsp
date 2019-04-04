<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/25
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>添加活动</title>
</head>
<body>

<form:form method = "GET" action = "submitAcInfo.do">
    <table>
        <tr>
            <td><form:label path = "name">活动名称：</form:label></td>
            <td><form:input path = "name" /></td>
        </tr>
        <tr>
            <td><form:label path = "time">时间</form:label></td>
            <td><form:input path = "time" /></td>
        </tr>
        <tr>
            <td><form:label path = "location">地点：</form:label></td>
            <td><form:input path = "location"></form:input></td>
        </tr>
        <tr>
            <td><form:label path = "num">人数上限：</form:label></td>
            <td><form:input path = "num"></form:input></td>
        </tr>
        <tr>
            <td><form:label path = "description">活动内容：</form:label></td>
            <td><form:input path = "description"></form:input></td>
        </tr>
        <tr>
            <td colspan = "2">
                <input type = "submit" value = "Submit"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
