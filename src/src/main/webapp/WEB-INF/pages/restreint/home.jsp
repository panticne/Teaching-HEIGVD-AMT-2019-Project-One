<%@ page import="javax.persistence.criteria.CriteriaBuilder" %><%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 25/10/2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<%@include file="../includes/header.jsp"%>
<body>
<div class="container text-center">
    <%@include file="../includes/nav.jsp"%>
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
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${page == 1}">
                <li class="page-item disabled"><a class="page-link">Previous</a></li>
            </c:if>
            <c:if test="${page != 1}">
                <li class="page-item"><a class="page-link" href="/Project-One/pages/home?page=previous">Previous</a></li>
            </c:if>
            <li class="page-item page-link disabled">
                <a class="page-link" href="">${page}/${nbPages}</a>
            </li>
            <c:if test="${page == nbPages}">
                <li class="page-item disabled"><a class="page-link">Next</a></li>
            </c:if>
            <c:if test="${page != nbPages}">
                <li class="page-item"><a class="page-link" href="/Project-One/pages/home?page=next">Next</a></li>
            </c:if>

        </ul>
    </nav>
    <%@include file="../includes/footer.jsp"%>
</div>
</body>
</html>
