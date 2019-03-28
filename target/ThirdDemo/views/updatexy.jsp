<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息界面</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/updateNowin.do" method="post">
    <input type="hidden" name="xid" value="${xy.xid}"/>
    <table>
        <tr>
            <th>name:</th>
            <td><input type="text" name="name" value="${xy.name}"></td>
        </tr>
        <tr>
            <th>sex:</th>
            <td><input type="text" name="sex" value="${xy.sex}"></td>
        </tr>
        <tr>
        <th>phone:</th>
        <td><input type="text" name="phone" value="${xy.phone}"></td>
        </tr>
        <tr>
            <th>email:</th>
            <td><input type="text" name="mail" value="${xy.mail}"></td>
        </tr>
        <tr>
            <th>pwd：</th>
            <td><input type="password" name="pw" value="${xy.pw}"> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="xiugai" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
