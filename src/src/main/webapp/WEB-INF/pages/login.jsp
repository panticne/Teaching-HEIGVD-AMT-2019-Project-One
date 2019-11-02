<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 28/10/2019
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="container">

    <form action="/Project-One/pages/login" method="post">
        <table style="with: 50%">
            <tr>
                <td>Pseudo</td>
                <td><input type="text" name="pseudo" required/></td>
            </tr>
            <tr>
                <td>Mot de passe</td>
                <td><input type="password" name="motdepasse" required/></td>
            </tr>
        </table>
        <input type="submit" value="Login" /></form>
    <form method="GET" action="/Project-One/pages/register" class="form-signin">
        <button id="bRegister" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div> <!-- /container -->

</body>
</html>
