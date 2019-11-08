<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 04.11.19
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<div class="jumbotron text-center">
    <h1>${title}</h1>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header" >
            <a class="navbar-brand" href="/Project-One/pages/home">Home</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/Project-One/pages/myAccount">Mon Compte</a></li>
            <li><a href="/Project-One/pages/mesVols?page=1">Mes vols</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/Project-One/pages/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
        </ul>
    </div>
</nav>