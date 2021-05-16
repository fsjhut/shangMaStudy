<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>商品显示界面</title>
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
    <form action="${pageContext.request.contextPath}/prod" method="post" class="form-inline">
        <div class="form-group">
            <label for="prodid">商品id</label>
            <input type="text" class="form-control" id="prodid" name="prodid" value="${queryProd.prodId}"
                   placeholder="prodid">
        </div>
        <div class="form-group">
            <label for="prodname">商品名称</label>
            <input type="text" class="form-control" id="prodname" name="prodname" value="${queryProd.prodName}"
                   placeholder="prodname">
        </div>
        <button type="submit" class="btn btn-info">查询</button>
    </form>
    <table class="table">
        <caption>商品信息</caption>
        <thead>
        <tr>
            <th>商品编号</th>
            <th>商品名称</th>
            <th>单价</th>
            <th>备注</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%--req.setAttribute("queryProd",myProduct);--%>
        <%--req.setAttribute("page",page);--%>
        <%--req.setAttribute("pageSize",pageSize);--%>
        <%--req.setAttribute("totalPage",totalPage);--%>
        <%--req.setAttribute("listProd",allProduct);--%>
        <c:forEach items="${ listProd }" var="myprod">
            <tr>
                <td>
                        ${myprod.prodId}
                </td>
                <td>
                    <img src="${pageContext.request.contextPath}/${myprod.prodImg}"/><br/>
                        ${myprod.prodName}
                </td>
                <td>${myprod.prodPrice}</td>
                <td>${myprod.prodDesc}</td>
                <td><input type="button" prodid="${myprod.prodId}" class="btn btn-info addCart" value="添加到购物车"></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
    <%--<a class="btn btn-default" href="${pageContext.request.contextPath}/prod?page=${page-1}&pageSize=${pageSize}">上一页</a>
<a class="btn btn-default" href="${pageContext.request.contextPath}/prod?page=${page+1}&pageSize=${pageSize}">下一页</a>
--%>
    <input id="prevBtn" type="button" class="btn btn-default"  value="上一页">
    <input id="nextBtn" type="button" class="btn btn-default" value="下一页">

    <span style="font-size: 18px">当前第 ${page} 页 每页显示 ${pageSize} 条记录  总共 ${totalPage} 页</span>
    <%--<a href="${pageContext.request.contextPath}/">去购物车</a>--%>
</div>
</body>
<script>
    var page = ${page};
    var totalPage = ${totalPage};
    // 点击上一页
    $("#prevBtn").click(function () {
        // 拼接新的网页连接--跳转到新的网页
        location.href = "${pageContext.request.contextPath}/prod?page=${page-1}&pageSize=${pageSize}"
            +"&prodid="+$("#prodid").val()+"&prodname="+$("#prodname").val();
    });
    $("#nextBtn").click(function () {
        // 拼接新的网页连接--跳转到新的网页
        location.href = "${pageContext.request.contextPath}/prod?page=${page+1}&pageSize=${pageSize}"
            +"&prodid="+$("#prodid").val()+"&prodname="+$("#prodname").val();
    });
    function checkBtn(){
        //当前页码
        if(page<=1){
            $("#prevBtn").prop("disabled",true);
        }

        if(page>=totalPage){
            $("#nextBtn").prop("disabled",true);
        }
    }
    checkBtn();
</script>
</html>
