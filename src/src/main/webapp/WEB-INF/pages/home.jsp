<%--
  Created by IntelliJ IDEA.
  User: panticne
  Date: 25/10/2019
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<h2>Welcome to the demo app!</h2>

<div class="alert alert-info" role="alert">
    Welcome to our wonderful website <%=request.getAttribute("pseudo") %>
</div>

</body>
</html>
