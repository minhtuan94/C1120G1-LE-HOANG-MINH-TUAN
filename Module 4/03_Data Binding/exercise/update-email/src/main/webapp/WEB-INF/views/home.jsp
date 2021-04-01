
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>home</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/email" method="post" modelAttribute="email">
<table style="">
    <tr>
        <th><form:label path="language">Language: </form:label></th>
        <td>
            <form:select path="language" cssStyle="width: 200px">
                <form:option value="English">English</form:option>
                <form:option value="Vietnamese">Vietnamese</form:option>
                <form:option value="Japanese">Japanese</form:option>
                <form:option value="Chinese">Chinese</form:option>
            </form:select>
        </td>
    </tr>

    <tr>
        <th><form:label path="pageSize">Page Size</form:label></th>
        <td>Show
            <form:select path="pageSize">
                <form:option value="5">5</form:option>
                <form:option value="10">10</form:option>
                <form:option value="15">15</form:option>
                <form:option value="25">25</form:option>
                <form:option value="50">50</form:option>
                <form:option value="100">100</form:option>
            </form:select>
            emails per page
        </td>
    </tr>

    <tr>
        <th><form:label path="spamsFilter">Spams filter:</form:label></th>
        <td><form:checkbox path="spamsFilter" value="Enable spams filter"/>Enable spams filter</td>
    </tr>

    <tr>
        <th><form:label path="signature"> Signature: </form:label></th>
        <td><form:textarea path="signature"/></td>
    </tr>

    <tr>
        <td></td>
        <td><input type="submit" value="Update"><input type="reset" value="Nhập lại"></td>
    </tr>
</table>
</form:form>
<hr>
<h1>INFORMATION</h1>
<h3>Language: ${email.language}</h3>
<h3>Page Size: ${email.pageSize}</h3>
<h3>Spams: ${email.spamsFilter}</h3>
<h3>Sign: ${email.signature}</h3>
</body>
</html>
