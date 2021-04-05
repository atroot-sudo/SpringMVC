<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<a href="test/2/hello">helloWorld</a>

<br>
<a href="test/book/2">查询图书</a><br>
<form action="test/book" method="post"><br>
    <input type="submit" value="添加图书">
</form>
<br>
<form action="test/book/2" method="post">
    <input name="_method" value="delete">
    <input type="submit" value="删除图书">
</form>

<form action="test/book/2" method="post">
    <input name="_method" value="put">
    <input type="submit" value="更新图书">
</form>
<br>
<br>
<form action="test/buyBook" method="post">
    书名：<input type="text" name="bookName"> <br>
    作者：<input type="text" name="author"> <br>
    价格：<input type="text" name="price"> <br>
    库存：<input type="text" name="stock"> <br>
    销量：<input type="text" name="sales"> <br>
    省：<input type="text" name="add.province"> <br>
    市：<input type="text" name="add.city"> <br>
    <input type="submit" name="保存"> <br>
</form>

<form action="test/handle06" method="post">
    书名：张三流浪记 <br>
    作者：<input type="text" name="author"> <br>
    价格：<input type="text" name="price"> <br>
    库存：<input type="text" name="stock"> <br>
    销量：<input type="text" name="sales"> <br>
    省：<input type="text" name="add.province"> <br>
    市：<input type="text" name="add.city"> <br>
    <input type="submit" name="保存"> <br>
</form>

</body>
</html>