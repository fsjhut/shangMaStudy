<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/11
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .loginPanel{
            margin: 300px auto;
            width: 500px;
            height: 350px;
            border: 1px solid lightgray;
            border-radius: 10px;
            padding: 30px;
        }
        .myalert{
            color: lightcoral;
        }

    </style>
</head>
<body>
<div class="loginPanel">
    <h1>登录</h1>
    <hr/>
    <form action="${pageContext.request.contextPath}/user/login" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="uname" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="uname" name="name" value="${inserUser.name}" placeholder="name">
            </div>
        </div>
        <div class="form-group">
            <label for="upwd" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="upwd" name="password" value="${inserUser.password}" placeholder="password">
            </div>
        </div>
        <hr/>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button><span class="myalert">${loginFailed}</span>
            </div>
        </div>
    </form>


</div>
</body>
</html>
