<%--
  Created by IntelliJ IDEA.
  User: duytr
  Date: 3/30/2021
  Time: 9:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Student List</h3>
<a href="#">Create</a>
<c:if test="${message != null}">
    <c:out value="${message}"/>
</c:if>
<table>
    <thead>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudent}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>
                <a href="#">Delete | </a>
                <a href="#">Edit | </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
