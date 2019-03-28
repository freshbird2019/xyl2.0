<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/27
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校友登录</title>
</head>
<body>
<h2>校友登录</h2>
<form action="${pageContext.request.contextPath}/checkXyLogin.do" method="post">
    <table>
        <tr>
            <td>name:</td>
            <td><input type="text" name="name" value=""> </td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type="password" name="pw" value=""> </td>
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
</form>
</body>
</html>
