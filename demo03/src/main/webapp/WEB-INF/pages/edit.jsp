<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.9
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    pageContext.setAttribute("reallyPath",request.getContextPath());
%>
<html>
<head>
    <title>Edit Employee page</title>
</head>
<body>
<h1 align="center">Modification of employee information</h1>
<form:form action="${reallyPath}/emp/${employee.id}" method="post" modelAttribute="employee">
    <input type="hidden" name="_method" value="put">
<%--    <input type="hidden" name="id" value="${employee.id}">--%>
    id : ${employee.id} <br>
    姓名: <form:input path="lastName"/> <br>
    email: <form:input path="email"/> <br>
    性别:
    男：<form:radiobutton path="gender" value="1"/> <br>
    女：<form:radiobutton path="gender" value="0"/> <br>
    部门：<form:select path="department.id" items="${dept}" itemValue="id" itemLabel="departmentName"/> <br>
    <input type="submit" value="提交修改！">
</form:form>

</body>
</html>
