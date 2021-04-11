<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.8
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>addEmployee</title>
</head>
<body>
<%-- path相当于之前写的name
 由于在这里使用了 form 标签所以，SpringMVC会认为每个表单中的数据都是需要回显的，那么就会在request的域中找command对象
 path中指定的属性，在请求域中都要要求有对象有对应的属性(该对象默认为请求域中的command对象)
 --%>
<%-- 取到真实地址 --%>
<%
    pageContext.setAttribute("reallyPath",request.getContextPath());
%>
<form:form action="${reallyPath}/emp" modelAttribute="employee" method="post">
    lastName: <form:input path="lastName"/> <form:errors path="lastName"/> <br>
    email: <form:input path="email"/> <form:errors path="email"/> <br>
    gender: <br>
    男：<form:radiobutton path="gender" value="1"/>
    女：<form:radiobutton path="gender" value="0"/> <br>
    birth : <form:input path="birth"/> <%--<form:errors path="birth"/>--%> <br>
    <%--    items 表示从request域中拿到的信息，itemLabel 表示展示给用户预览的选项的"假值" itemValue 则为实际要传给服务器的值--%>
    部门： <form:select path="department.id" items="${dept}" itemLabel="departmentName" itemValue="id"/> <br>
    <input type="submit" value="保存！">
</form:form>

<%--
<form action="">
    lastName:<input type="text" name="lastName"> <br>
    email:<input type="text" name="email"> <br>
    gender: 男：<input type="radio" name="gender" value="1"> <br>
    女：<input type="radio" name="gender" value="0"> <br>
    department： <select name="department.name">
    <c:forEach items="${dept}"  var="item" >
        <option value="${item.id}">${item.departmentName}</option>
    </c:forEach>

</select>
    <input type="submit" value="提交！">
</form>--%>
</body>
</html>
