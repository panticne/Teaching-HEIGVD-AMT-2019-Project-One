<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04.11.19
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>
<div class="container">
    <%@include file="../includes/nav.jsp"%>
    <table class="table table-dark">
        <thead>
        <tr>
            <th scope="col">Compagnie</th>
            <th scope="col">Type Avion</th>
            <th scope="col">Départ</th>
            <th scope="col">Arrivée</th>
            <th scope="col">Durée</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${vols}" var="vol">
                <tr>
                    <td>${vol.avion.compagnie}</td>
                    <td>${vol.avion.type}</td>
                    <td>${vol.trajet.start}</td>
                    <td>${vol.trajet.end}</td>
                    <td>${vol.trajet.time}</td>
                    <td><a type="button" href="/Project-One/pages/modifierVol?id=${vol.id}" class="btn btn-primary"><span class="glyphicon glyphicon-cog" /></a></td>
                    <td><form action="/Project-One/pages/mesVols" method="post">
                        <input name="id" value="${vol.id}" hidden="hidden"/>
                        <button type="submit"  class="btn btn-danger"><span class="glyphicon glyphicon-remove" /></button>
                    </form></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <a href="/Project-One/pages/ajouterVol"  class="btn btn-primary center">Ajouter un nouveau vol</a>
    </div>
    <%@include file="../includes/footer.jsp"%>
</div>
</body>
</html>
