<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 06.11.19
  Time: 15:14
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
                <form action="/Project-One/pages/ajouterVol" method="post">
                    <table class="table table-dark w-75">
                        <thead>
                        <tr>
                            <td>Avion</td>
                            <td><select name="avion">
                                <c:forEach items="${avions}" var="avion">
                                    <option value="${avion.id}">${avion.compagnie} - ${avion.type}</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <td scope="col">Trajet</td>
                            <td><select name="trajet">
                                <c:forEach items="${trajets}" var="trajet">
                                    <option value="${trajet.id}">${trajet.start}->${trajet.end}(${trajet.time} min.)</option>
                                </c:forEach>
                            </select></td>
                        </tr>
                        </thead>
                    </table>
                    <input hidden="hidden" value="${piloteId}" name="piloteId" />
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Confirmer"/>
                    <a class="btn btn-lg btn-primary btn-block" href="/Project-One/pages/mesVols">Annuler</a>
                </form>
            </div>
        </div>
        <%@include file="includes/footer.jsp"%>
    </div>
</body>
</html>
