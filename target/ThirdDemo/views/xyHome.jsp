<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/3/27
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户界面</title>
</head>
<body>
<div>
    <a href="getAllClazz?id=${nowinxy.xid}">申请加入班级</a>
    <a href="getAllXy">查看班级成员</a>
    <a href="updateXy.do?id=${nowinxy.xid}">修改个人资料</a>
    <a href="XygetAllLy?id=${nowinxy.xid}">浏览留言</a>
    <a href="activityPg">活动界面</a>
</div>
</body>
</html>
