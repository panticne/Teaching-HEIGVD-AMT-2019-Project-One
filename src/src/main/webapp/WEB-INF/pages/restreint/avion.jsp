<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 25/10/2019
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Avions</title>
</head>
<body>
<h1>Avions</h1>
<table>
    <c:forEach items="${avions}" var="avion">
        <tr>
            <td>${avion.id}</td>
            <td>${avion.compagnie}</td>
            <td>${avion.type}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
