<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/11
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="common.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    欢迎回来${loginUser.uname}
    <hr/>
    可使用的服务<br/>
    <a href="${pageContext.request.contextPath}/user">用户服务</a>
    <a href="${pageContext.request.contextPath}/order">订单服务</a>
    <a href="${pageContext.request.contextPath}/product">产品服务</a>
</body>
</html>
