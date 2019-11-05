<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04.11.19
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="includes/header.jsp"%>
<body>
    <div class="container">
        <%@include file="includes/nav.jsp"%>
        <div class="row justify-content-md-center">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <table class="table table-dark">
                    <thead>
                    <tr>
                        <td scope="col">Prénom</td>
                        <td>${pilote.prenom}</td>
                    </tr>
                    <tr>
                        <td scope="col">Nom</td>
                        <td>${pilote.nom}</td>
                    </tr>
                    <tr>
                        <td scope="col">Pseudo</td>
                        <td>${pilote.pseudo}</td>
                    </tr>
                    <tr>
                        <td scope="col">Mot de passe</td>
                        <td>${pilote.motdepasse}</td>
                    </tr>
                    </thead>
                </table>
                <a class="btn btn-lg btn-primary btn-block" href="/Project-One/pages/changerMdp">Modifier le mot de passe</a>
            </div>
        </div>
        <%@include file="includes/footer.jsp"%>
    </div>
</body>
</html>
