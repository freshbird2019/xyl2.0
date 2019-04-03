<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/18
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言添加</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/XyaddLy.do?id=${nowinxy.xid}" method="post">
        <input type="text" name="info" value=""/>
        <input type="submit" name="lyok" value="liuyan"/>
    </form>
</body>
</html>
