<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/11
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<c:if test="${empty loginuser}">
    <%--  重定向时 redirect拼上了项目名  --%>
    <c:redirect url="/pages/user/login.jsp"></c:redirect>
</c:if>
