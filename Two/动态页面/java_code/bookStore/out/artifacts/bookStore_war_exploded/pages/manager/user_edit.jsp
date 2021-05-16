<%@ page contentType="text/;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>编辑用户</title>
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" >
        <style type="text/css">
            h1 {
            text-align: center;
            margin-top: 200px;
            }

            h1 a {
            color:red;
            }

            input {
            text-align: center;
            }
        </style>
    </head>
    <body>
        <div id="header">
            <img class="logo_img" alt="" src="${pageContext.request.contextPath}/img/logo.gif">
            <span class="wel_word">编辑图书</span>
            <div>
                <a href="book_manager.jsp">图书管理</a>
                <a href="order_manager.jsp">订单管理</a>
                <a href="user_manager.jsp">用户管理</a>
                <a href="${pageContext.request.contextPath}/index.jsp">返回商城</a>
            </div>
        </div>

        <div id="main">
            <form action="book_manager.jsp">
                <table>
                    <tr>
                        <td>名字</td>
                        <td>手机号</td>
                        <td>邮箱</td>
                        <td>生日</td>
                        <td>地址</td>
                        <td colspan="2">操作</td>
                    </tr>
                    <tr>
                        <td>
                            <input name="user_name" type="text" value="时间简史"/>
                        </td>
                        <td>
                            <input name="user_phone" type="text" value="30.00"/>
                        </td>
                        <td>
                            <input name="user_email" type="text" value="霍金"/>
                        </td>
                        <td>
                            <input name="user_birth" type="text" value="200"/>
                        </td>
                        <td>
                            <input name="user_address" type="text" value="300"/>
                        </td>
                        <td>
                            <input type="submit" value="提交"/>
                        </td>
                    </tr>
                </table>
            </form>


        </div>

        <div id="bottom">
            <span>
                网上书城.Copyright 2021
            </span>
        </div>
    </body>
</html>