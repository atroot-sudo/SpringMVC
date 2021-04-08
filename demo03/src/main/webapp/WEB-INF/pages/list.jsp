<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.8
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>EmployeeList</title>
</head>
<body>
<h1 align="center">This is a List of All Employee.</h1>
<table border="1" cellpadding="1" cellspacing="0" align="center">
    <tr>
        <th>ID</th>
        <th>lastName</th>
        <th>email</th>
        <th>gender</th>
        <th>departmentName</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach items="${emps}" var="emp">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.lastName}</td>
            <td>${emp.email}</td>
            <td>${emp.gender == 1? "男":"女"}</td>
            <td>${emp.department}</td>
            <td>EDIT</td>
            <td>DELETE</td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="toAddPage">添加员工</a>
</body>
</html>