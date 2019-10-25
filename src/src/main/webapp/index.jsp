<html>
<body>
<h2>Hello World!</h2>
<c:foreach items="${pilote}" var="pilote">
    <p>${pilote.id}</p>
    <p>${pilote.firstname}</p>
    <p>${pilote.lastname}</p><br>
</c:foreach>
</body>
</html>
