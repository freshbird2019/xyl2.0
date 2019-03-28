<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="xyl.cct.pojo.Xy" %>
<%@ page import="xyl.cct.pojo.Clazz" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/28
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>管理班级</title>
</head>
<body>
<%
    int index = 0;
    List<Integer> loca = new ArrayList<Integer>();
    List<Clazz> claList = (List<Clazz>)request.getAttribute("classList");
    Map<Integer, List<Xy>> map = (Map<Integer, List<Xy>>)request.getAttribute("applyMap");

    for (Clazz cla : claList) {
        List<Xy> currNum = map.get(cla.getCid());

        loca.add(currNum.size());
    }

%>
<div>

    <form action="#" method="get">
        <table border="1">
            <tr>
                <th>班级ID</th>
                <th>班级名</th>
                <th>届</th>
                <th>专业</th>
                <th>学院</th>
                <th>待审核请求</th>
            </tr>
            <c:forEach var="claItem" items="${classList}">
                <tr>
                    <td>${claItem.cid}</td>
                    <td>${claItem.name}</td>
                    <td>${claItem.year}</td>
                    <td>${claItem.major}</td>
                    <td>${claItem.college}</td>
                    <td>
                        <%
                            out.print(loca.indexOf(index));
                            index++;
                        %>
                    </td>
                    <td>
                        <a href="deleteAc.do?id=${acItem.aid}">delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="addAc.do">添加</a>
    </form>
</div>

</body>
</html>
