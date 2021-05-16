<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <style>
        .mainPanel{
            width: 80%;
            margin: 100px auto;
        }
        td>img{
            width: 64px;
            height: 64px;
        }

    </style>
</head>
<body>

<div class="mainPanel">
    <table class="table">
        <caption>商品信息</caption>
        <thead>
        <tr><th>商品编号</th><th>商品名称</th><th>单价</th><th>备注</th><th>操作</th></tr>
        </thead>
        <tbody>
        <c:forEach items="${ listProd }" var="myprod">
            <tr>
                <td>
                        ${myprod.prodId}
                </td>
                <td>
                    <img src="${pageContext.request.contextPath}/${myprod.prodImg}" /><br/>
                        ${myprod.prodName}
                </td>
                <td>${myprod.prodPrice}</td>
                <td>${myprod.prodDesc}</td>
                <td><input type="button" prodid="${myprod.prodId}" class="btn btn-info addCart" value="添加到购物车"></td>
            </tr>
        </c:forEach>


        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/cart">去购物车</a>
</div>

</body>
<script>
     //prod_商品编号
    //document.cookie = "prod_商品编号=1;path=/;expires="+new Date("2033-12-11 12:12:12");
    $(".addCart").click(function(){
        var pid = $(this).attr("prodid");
        console.log(pid);
        var prodid = "prod_"+pid;
        var prodnum = 1;
        var cookieArr = document.cookie.split("; ");
        $.each(cookieArr,function(i,d){
            var kandv = d.split("=");
            if(prodid == kandv[0]){
                //如果要添加的cookie 已经存在 取出当前值加1
                prodnum = parseInt(kandv[1])+1
            }
        });
        document.cookie = prodid+"="+prodnum+";path=/;expires="+new Date("2033-12-11 12:12:12");
    })

</script>
</html>
