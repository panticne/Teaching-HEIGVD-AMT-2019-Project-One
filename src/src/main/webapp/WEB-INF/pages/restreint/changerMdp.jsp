<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04.11.19
  Time: 20:50
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
                <form action="/Project-One/pages/changerMdp" method="post">
                    <input class="form-control input-lg" placeholder="Ancien mot de passe" type="password" name="oldPassword" required/>
                    <input class="form-control input-lg" placeholder="Nouveau mot de passe" type="password" name="newPassword" required/>
                    <input class="form-control input-lg" placeholder="Confirmer nouveau mot de passe" type="password" name="confirmPassword" required/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Confirmer" />
                </form>
            </div>
        </div>
    </div>
</body>
</html>
