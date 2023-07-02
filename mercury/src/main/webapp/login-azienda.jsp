<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Login partner</h1>

<p>${error}</p>
<p>${errorCheck}</p>

<form action="/login-azienda" method="get">
    <input type="hidden" value="reg" name="reg">

    <label>UserName</label>
    <input type="text" name="name"><br>

    <label>Partita iva</label>
    <input type="password" name="p_iva"><br>

    <button type="submit">Login!</button>

</form> <br>

<a href="register-azienda.jsp">Registrati</a> <br>
<a href="index.jsp">Ritorna alla home</a> <br>


</body>
</html>
