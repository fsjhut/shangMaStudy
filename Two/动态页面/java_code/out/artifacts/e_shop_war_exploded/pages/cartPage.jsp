<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="common.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript"
            charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"
            charset="utf-8"></script>
    <style>
        .mainPanel {
            width: 80%;
            margin: 100px auto;
        }

        td > img {
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
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>单价</th>
            <th>数量</th>
            <th>小计</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${ prodList }" var="myprod">
            <tr>
                <td>
                        ${myprod.prodId}
                </td>
                <td>
                    <img src="${pageContext.request.contextPath}/${myprod.prodImg}"/><br/>
                        ${myprod.prodName}
                </td>
                <td>${myprod.prodPrice}</td>
                <td><input class="numBtn"   type="button" value="-">
                    <input id="prodNum" oninput="inputChange(this,-1)" prodprice="${myprod.prodPrice}"
                           type="text" prodid="${myprod.prodId}" value="${myprod.prodNum}">
                    <input class="numBtn"  type="button" value="+"></td>
                <td><span id="allprice">${myprod.prodPrice*myprod.prodNum}</span></td>
                <td><input type="button" prodid="${myprod.prodId}" class="btn btn-danger deleteProd" value="删除">
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>

</body>
<script>
    // 购物车中可以增加、减少商品，
    $(".numBtn").click(function () {
        // 将改动保存到cookie中
        // var pid = $(this).attr("prodid");
        // console.log(pid);
        // var prodid = "prod_" + pid;
        var num = 0;
        if ($(this).val() == '+') {
            $(this).prev().prev().prop("disabled", false);
            var startNum = $(this).prev().val();
            if (startNum == 9) {
                $(this).prop("disabled", true);
            }
            num = parseInt(startNum) + 1;
            $(this).prev().val(num);
            inputChange($(this).prev(),num);
        }
        if ($(this).val() == '-') {
            $(this).next().next().prop("disabled", false);
            var startNum = $(this).next().val();
            if (startNum == 2) {
                $(this).prop("disabled", true);
            }
            num = parseInt(startNum) - 1;
            $(this).next().val(num);
            inputChange($(this).next(),num);
        }

        // document.cookie = prodid + "=" + num + ";path=/;expires=" + new Date("2033-12-11 12:12:12");

    });
    function inputChange(obj,num){
        if(num==-1){
            // 输入框的改变
            num = $(obj).val();
        }
        var pid = $(obj).attr("prodid");
        var prodid = "prod_" + pid;
        document.cookie = prodid + "=" + num + ";path=/;expires=" + new Date("2033-12-11 12:12:12");
        // 计算总金额
        var price = $(obj).attr("prodprice");
        var totalprice = (num*price).toFixed(2);
        console.log(totalprice);
        $("#allprice").val(totalprice);
        location.reload();
    }
    $(".deleteProd").click(function () {
        $(this).parent().parent().remove();
        var pid = $(this).attr("prodid");
        console.log(pid);
        var prodid = "prod_" + pid;
        var prodnum = 0;
        document.cookie = prodid + "=" + prodnum + ";path=/;expires=" + new Date("2001-12-11 12:12:12");
        location.reload();
    });

</script>
</html>
