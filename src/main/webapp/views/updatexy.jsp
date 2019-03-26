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
<form action="${pageContext.request.contextPath}/update.do" method="post">
    <input type="hidden" name="xyId" value="${xy.xyId}"/>
    <table>
        <tr>
            <th>name:</th>
            <td><input type="text" name="xyUsername" value="${xy.xyUsername}"></td>
        </tr>
        <tr>
            <th>age:</th>
            <td><input type="text" name="xyAge" value="${xy.xyAge}"></td>
        </tr>
        <tr>
        <th>sex:</th>
        <td><input type="text" name="xySex" value="${xy.xySex}"></td>
        </tr>
        <tr>
            <th>phone:</th>
            <td><input type="text" name="xyPhone" value="${xy.xyPhone}"></td>
        </tr>
        <tr>
            <th>email:</th>
            <td><input type="text" name="xyEmail" value="${xy.xyEmail}"></td>
        </tr>
        <tr>
            <th>pwd：</th>
            <td><input type="password" name="xyPassword" value="${xy.xyPassword}"> </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" name="xiugai" value="修改"></td>
        </tr>
    </table>
</form>
</body>
</html>
