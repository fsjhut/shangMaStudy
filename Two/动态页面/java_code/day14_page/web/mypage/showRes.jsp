<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/17
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img style="width: 300px;height: 300px" src=" ${pageContext.request.contextPath}/${resImg}">
<br/>
${resMsg}
</body>
<script>
    setTimeout(function(){
        location.href = "${pageContext.request.contextPath}/prod/query"
    },2000)


</script>
</html>
