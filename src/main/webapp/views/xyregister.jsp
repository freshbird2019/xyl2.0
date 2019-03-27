<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/25
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>校友注册界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/register.do" method="post">
    <table>
        <tr>
            <th>name:</th>
            <td><input type="text" name="name" value=""></td>
        </tr>
        <tr>
            <th>password:</th>
            <td><input type="password" name="pw" value=""></td>
        </tr>
    <tr>
        <th>sex:</th>
        <td><input type="text" name="sex" value=""></td>
    </tr>
    <tr>
        <th>phone:</th>
        <td><input type="text" name="phone" value=""></td>
    </tr>
    <tr>
        <th>email:</th>
        <td><input type="text" name="mail" value=""></td>
    </tr>
    <tr>
        <td colspan="2"><input type="submit" name="xiugai" value="注册"></td>
    </tr>
    </table>
</form>
</body>
</html>
