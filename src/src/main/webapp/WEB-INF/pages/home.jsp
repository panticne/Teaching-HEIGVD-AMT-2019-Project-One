<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 25/10/2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<%@include file="includes/header.jsp"%>
<body>
<div class="container">
    <%@include file="includes/nav.jsp"%>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Nom</th>
            <th scope="col">Prenom</th>
            <th scope="col">Compagnie</th>
            <th scope="col">Type Avion</th>
            <th scope="col">Départ</th>
            <th scope="col">Arrivée</th>
            <th scope="col">Durée</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${vols}" var="vol">
                <tr>
                    <td>${vol.pilote.prenom}</td>
                    <td>${vol.pilote.nom}</td>
                    <td>${vol.avion.compagnie}</td>
                    <td>${vol.avion.type}</td>
                    <td>${vol.trajet.start}</td>
                    <td>${vol.trajet.end}</td>
                    <td>${vol.trajet.time}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <%@include file="includes/footer.jsp"%>
</div>
</body>
</html>
