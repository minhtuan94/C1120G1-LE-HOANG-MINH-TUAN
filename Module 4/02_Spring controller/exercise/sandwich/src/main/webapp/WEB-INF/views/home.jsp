<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30/03/2021
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save" method="post">
    <table>
        <tr>
            <td><input type="checkbox" name="condiment" value="Lettuce">Lettuce</td>
            <td><input type="checkbox" name="condiment" value="Tomato">Tomato</td>
            <td><input type="checkbox" name="condiment" value="Mustard">Mustard</td>
            <td><input type="checkbox" name="condiment" value="Sprouts">Sprouts</td>
        </tr>
    </table>
    <hr>
    <input type="submit" value="Save">
</form>
</body>
</html>
