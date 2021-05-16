<%--
  Created by IntelliJ IDEA.
  User: JAVASM
  Date: 2021/5/11
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<c:if test="${empty loginUser}">
    <c:redirect url="/login.jsp"></c:redirect>
</c:if>
