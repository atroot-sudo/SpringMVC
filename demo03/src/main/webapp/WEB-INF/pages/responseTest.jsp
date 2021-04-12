<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.12
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title></head>
<%
    pageContext.setAttribute("reallyPath",request.getContextPath());
%>
<body>
<h1>responseBody</h1>
<form action="${reallyPath}/responseBody" method="post">
    username <input type="text" name="username" value="zhang"> <br>
    password <input type="text" name="password" value="123456">
    <input type="submit" value="走你！">
</form>

</body>
</html>
