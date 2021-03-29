<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29/03/2021
  Time: 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Converter</h1>
<form action="/money" method="post">
    <input type="text" name="num1">
    <input type="text" name="num2" readonly value="23000">
    <button type="submit">Convert</button>
</form>
</body>
</html>
