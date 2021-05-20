<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <form action="${pageContext.request.contextPath}/prod/query" method="post" class="form-inline">
        <div class="form-group">
            <label for="prodid">商品id</label>
            <input type="text" class="form-control" id="prodid" name="prodid" value="${queryProd.prodId}" placeholder="prodid">
        </div>
        <div class="form-group">
            <label for="prodname">商品名称</label>
            <input type="text" class="form-control" id="prodname" name="prodname" value="${queryProd.prodName}" placeholder="prodname">
        </div>
        <button type="submit" class="btn btn-info">查询</button>
        <button id="addBtn" type="button" class="btn btn-success">添加</button>
    </form>
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
                <td><input type="button" prodid="${myprod.prodId}" class="btn btn-warning editBtn" value="修改"></td>
            </tr>
        </c:forEach>


        </tbody>
    </table>

    <%--<a class="btn btn-default" href="${pageContext.request.contextPath}/prod?page=${page-1}&pageSize=${pageSize}">上一页</a>
    <a class="btn btn-default" href="${pageContext.request.contextPath}/prod?page=${page+1}&pageSize=${pageSize}">下一页</a>
--%>
    <input id="prevBtn" type="button" class="btn btn-default"  value="上一页">
    <input id="nextBtn" type="button" class="btn btn-default" value="下一页">

    当前第 ${page} 页 每页显示 ${pageSize} 条记录  总共 ${totalPage} 页
</div>

</body>
<script>
    var page = ${page};
    var totalPage = ${totalPage};

     //prod_商品编号
    //document.cookie = "prod_商品编号=1;path=/;expires="+new Date("2033-12-11 12:12:12");
    $(".addCart").click(function(){
        var pid = $(this).attr("prodid");
        var prodid = "prod_"+pid;
        var prodnum = 1;
        var cookieArr = document.cookie.split("; ");
        $.each(cookieArr,function(i,d){
            var kandv = d.split("=");
            if(prodid == kandv[0]){
                //如果要添加的cookie 已经存在 取出当前值加1
                prodnum = parseInt(kandv[1])+1
            }
        })

        document.cookie = prodid+"="+prodnum+";path=/;expires="+new Date("2033-12-11 12:12:12");
    })


    $(".editBtn").click(function(){
        location.href = "${pageContext.request.contextPath}/prod/readyForEdit?prodId="+$(this).attr("prodid");
    })

     $("#prevBtn").click(function(){
         location.href = "${pageContext.request.contextPath}/prod/query?page=${page-1}&pageSize=${pageSize}"
                         +"&prodid="+$("#prodid").val()+"&prodname="+$("#prodname").val();
     })

     $("#nextBtn").click(function(){
         location.href = "${pageContext.request.contextPath}/prod/query?page=${page+1}&pageSize=${pageSize}"
                         +"&prodid="+$("#prodid").val()+"&prodname="+$("#prodname").val();
     })

    $("#addBtn").click(function(){
        location.href="${pageContext.request.contextPath}/mypage/addProdPage.jsp";
    })


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
