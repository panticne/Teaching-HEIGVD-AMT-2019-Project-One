<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 25/10/2019
  Time: 01:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pilote</title>
</head>
<body>
    <h1>actors</h1>
    <table>
        <c:forEach items="${pilotes}" var="pilote">
            <tr>
                <td>${pilote.firstname}</td>
                <td>${pilote.lastname}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
