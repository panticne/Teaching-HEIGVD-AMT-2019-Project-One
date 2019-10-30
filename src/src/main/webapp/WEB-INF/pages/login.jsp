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

    <form method="POST" action="auth" class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="hidden" name="action" value="login">
        <input type="hidden" name="targetUrl" value="${targetUrl}">
        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name ="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button id="bSignIn" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
    <form method="GET" action="/Project-One/pages/register" class="form-signin">
        <button id="bRegister" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div> <!-- /container -->

</body>
</html>
