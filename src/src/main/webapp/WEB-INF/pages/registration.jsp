<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Guru Registration Form</title>
</head>
<body>
<h1>Inscription</h1>
<form action="/Project-One/pages/register" method="post">
    <table style="with: 50%">
        <tr>
            <td>Prénom</td>
            <td><input type="text" name="prenom" required /></td>
        </tr>
        <tr>
            <td>Nom</td>
            <td><input type="text" name="nom" required /></td>
        </tr>
        <tr>
            <td>Pseudo</td>
            <td><input type="text" name="pseudo" required/></td>
        </tr>
        <tr>
            <td>Mot de passe</td>
            <td><input type="password" name="motdepasse" required/></td>
        </tr>
    </table>
    <input type="submit" value="Submit" /></form>
</body>
</html>