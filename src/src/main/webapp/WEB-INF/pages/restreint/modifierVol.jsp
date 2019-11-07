<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 05.11.19
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="../includes/header.jsp"%>
<body>
    <div class="container">
        <%@include file="../includes/nav.jsp"%>
        <div class="row justify-content-md-center">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <form action="/Project-One/pages/modifierVol" method="post">
                    <table class="table table-dark w-75">
                        <thead>
                        <tr>
                            <td>Avion</td>
                            <td><select name="avion">
                                <c:forEach items="${avions}" var="avion">
                                    <c:choose>
                                        <c:when test="${vol.avion.id == avion.id}">
                                            <option selected value="${avion.id}">${avion.compagnie} - ${avion.type}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${avion.id}">${avion.compagnie} - ${avion.type}</option>
                                        </c:otherwise>
                                    </c:choose>

                                </c:forEach>
                            </select></td>
                        </tr>
                        <tr>
                            <td scope="col">Trajet</td>
                            <td><select name="trajet">
                                <c:forEach items="${trajets}" var="trajet">
                                    <c:choose>
                                        <c:when test="${vol.trajet.id == trajet.id}">
                                            <option selected value="${trajet.id}">${trajet.start}->${trajet.end}(${trajet.time} min.)</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${trajet.id}">${trajet.start}->${trajet.end}(${trajet.time} min.)</option>
                                        </c:otherwise>
                                    </c:choose>

                                </c:forEach>
                            </select></td>
                        </tr>
                        </thead>
                    </table>
                    <input hidden="hidden" value="${vol.id}" name="vol" />
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Confirmer"/>
                    <a class="btn btn-lg btn-primary btn-block" href="/Project-One/pages/mesVols">Annuler</a>
                </form>
            </div>
        </div>
    </div>
    <%@include file="../includes/footer.jsp"%>
</body>
</html>
