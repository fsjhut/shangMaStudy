<%@ page contentType="text/jsp;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>会员登录页面</title>
		<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" type="text/javascript"
		charset="utf-8"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/mystyle.css" >

	</head>
	<body>
		<div id="l_content">
			<!-- <span class="login_word">欢迎登录</span> -->
		</div>
		<div class="login_form">
			<div class="login_box">
				<div class="tit">
					<h1>会员登录</h1>
					<a href="/book/pages/user/regist.jsp">立即注册</a>
				</div>
				<div class="msg_cont" align="left">
					<b></b>
					<span class="errorMsg">请输入用户名和密码</span>
				</div>
				<div class="form">
					<!--action="/book/pages/user/login_success.jsp"-->
					<form class="form-horizontal" action="/book/login" method="post">
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">用户名称:</label>
							<div class="col-sm-9">
								<input type="text" name="username" class="form-control" id="username"
									placeholder="请输入用户名" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<label for="password" class="col-sm-3 control-label">用户密码:</label>
							<div class="col-sm-9">
								<input type="password" name="password" class="form-control" id="password"
									placeholder="请输入密码" autocomplete="off">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-1 col-sm-3">
								<button type="submit" id="sub_btn" class="btn btn-default">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		$("#sub_btn").click(function(){
			var usernameValue = $("#username").val();
			// 定义验证规则
			var usernameReg = /^\w{5,15}/;
			if(!usernameReg.test(usernameValue)){
				alert("用户名不合法！")
				return false;
			}
			// 获取密码
			var passwordValue = $("#password").val();
			// 验证密码是否合法,规则如下：必须由字母，数字，下划线组成，并且长度为5到15位。
			var passwordReg = /^\w{5,15}$/;
			// 验证用户信息
			if (!passwordReg.test(passwordValue)) {
				// 提示用户
				alert("密码不合法！");
				return false;
			}
			return true;
		})
	</script>
</html>
