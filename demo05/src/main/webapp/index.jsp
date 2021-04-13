<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.13
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("reallyPath", request.getContextPath());
%>
<head>
    <title>hello</title>
</head>
<body>
<a href="${reallyPath}/test01?i=10">hello</a>
<a href="${reallyPath}/test02?i=10">hello</a>
</body>
</html>
