<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/11
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common.jsp"%>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
</head>
<body>
<table class="table">
    <caption>学员信息表</caption>
    <thead>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>电话</th>
        <th>备注</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ listUser }" var="myuser">
    <tr>
        <td>${myuser.uid}</td>
        <td>${myuser.uname}</td>
        <td>${myuser.uphone}</td>
        <td>${myuser.uremark}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
