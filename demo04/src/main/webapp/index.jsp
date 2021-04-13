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
<form action="${reallyPath}/uploadMore" method="post" enctype="multipart/form-data">
    文件 ：<input type="file" name="headerImg"/> <br>
    文件 ：<input type="file" name="headerImg"/> <br>
    文件 ：<input type="file" name="headerImg"/> <br>
    文件 ：<input type="file" name="headerImg"/> <br>
    用户名 ：<input name="username" type="text"/> <br>

    <input type="submit" value="上传!">

</form>
</body>
</html>
