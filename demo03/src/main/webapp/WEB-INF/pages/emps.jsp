<%--
  Created by IntelliJ IDEA.
  User: zheng
  Date: 2021.4.12
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    pageContext.setAttribute("reallyPath", request.getContextPath());
%>
<head>
    <title>emps</title>
    <script type="text/javascript" src="${reallyPath}/scripts/jquery-1.9.1.min.js"></script>
</head>
<body>
<a href="${reallyPath}/ajaxTest">Ajax获取员工数据</a> <br>
<div id="da1">

</div>
<script type="text/javascript">
    $("a:first").click(function () {

        $.ajax({
            url: "${reallyPath}/ajaxTest",
            type: "GET",
            success: function (data) {
                $.each(data, function () {
                    var empInfo = this.id + this.lastName + "---" + this.birth + "---" + this.gender + "---" + this.email + "---" + this.department;
                    $("da1").append(empInfo + "<" + "br" + ">");
                })
            }
        });
    });

</script>
</body>
</html>
