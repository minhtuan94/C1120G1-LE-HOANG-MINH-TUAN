<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/03/2021
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>CALCULATOR</h1>
<form action="/calc" method="post">
    <table>
        <tr>
            <td colspan="2"><input type="text" name="num1"></td>
            <td colspan="2"><input type="text" name="num2"></td>
        </tr>
        <tr>
            <td><button type="submit" name="calc" value="Addition(+)">Addition(+)</button></td>
            <td><button type="submit" name="calc" value="Subtraction(-)">Subtraction(-)</button></td>
            <td><button type="submit" name="calc" value="Multiplication(x)">Multiplication(x)</button></td>
            <td><button type="submit" name="calc" value="Division(/)">Division(/)</button></td>
        </tr>
    </table>
</form>
<h3>Result: ${result}</h3>
</body>
</html>
