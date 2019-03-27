<%@ page import="java.util.List" %>
<%@ page import="xyl.cct.pojo.Ly" %><%--
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

    <script type="text/javascript">
        $(function(){
            var ly='<%=request.getAttribute("lyList")%>'; //这种方法取出来是user是String类型

        })
    </script>
</head>
<body>
<form action="#" method="get">
    <table border="1">
        <tr>
            <th>留言ID</th>
            <th>留言人ID</th>
            <th>留言日期</th>
            <th>留言内容</th>
            <th>留言状态</th>
            <th>删除</th>
            <th>通过</th>
        </tr>
        <c:forEach var="lyItem" items="${lyList}">
            <tr>
                <td>${lyItem.lid}</td>
                <td>null</td>
                <td>${lyItem.lydate}</td>
                <td>${lyItem.info}</td>
                <td>
                    <%
                        // 这里对状态进行判断
                        int i=0;
                        List<Ly> list = (List<Ly>) request.getAttribute("lyList");

                        if(list.get(i).getState() == 1) {
                            out.print("通过");
                        } else {
                            out.print("未通过");
                        }
                    %>
                </td>
                <td>
                    <a href="deleteLy.do?id=${lyItem.lid}">删除</a>
                </td>
                <td>
                    <a href="admitLy.do?">通过</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="addLy.do">添加</a>
</form>

</body>
</html>
