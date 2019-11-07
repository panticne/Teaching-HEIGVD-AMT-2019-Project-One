<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron text-center">
            <h1>Inscription</h1>
        </div>
        <div class="row justify-content-md-center">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                <form action="/Project-One/register" method="post">
                    <input class="form-control input-lg" placeholder="Prénom" type="text" name="prenom" required />
                    <input class="form-control input-lg" placeholder="Nom" type="text" name="nom" required />
                    <input class="form-control input-lg" placeholder="Pseudo" type="text" name="pseudo" required/>
                    <input class="form-control input-lg" placeholder="Mot de passe" type="password" name="motdepasse" required/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Submit" />
                </form>
            </div>
        </div>
    </div>
</body>
</html>