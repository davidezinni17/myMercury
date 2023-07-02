<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>PARTNER REGISTER</h1> <br>

<p>${error}</p> <br>

<form action="/register-azienda" method="post">

    <label>Nome </label>
    <input type="text" name="name"><br>

    <label>Luogo</label>
    <input type="text" name="luogo"><br>

    <label>Numero</label>
    <input type="text" name="numero"><br>

    <label>Partita iva</label>
    <input type="text" name="p_iva"><br>

    <button type="submit">Registrati!</button>

</form>

</body>
</html>
