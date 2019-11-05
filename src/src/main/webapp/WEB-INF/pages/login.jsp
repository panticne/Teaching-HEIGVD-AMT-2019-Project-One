<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 28/10/2019
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron text-center">
            <h1>Login</h1>
        </div>
        <div class="row justify-content-md-center">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <form action="/Project-One/pages/login" method="post">
                    <input class="form-control input-lg" placeholder="Username" type="text" name="pseudo" required/>
                    <input class="form-control input-lg" placeholder="Password" type="password" name="motdepasse" required/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login" />
                    <a class="btn btn-lg btn-primary btn-block" href="/Project-One/pages/register"> Register</a>
                </form>
            </div>
        </div>
        <%@include file="includes/footer.jsp"%>
    </div>
</body>
</html>
