<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 03/07/2023
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>BECOMES NEW ADMIN </h1> <br>

<p>${error}</p> <br>
<form action="/register-admin" method="post">

    <label>Nome </label>
    <input type="text" name="name"><br>

    <label>Cognome</label>
    <input type="text" name="surname"><br>

    <label>Username</label>
    <input type="text" name="username"><br>

    <label>Email</label>
    <input type="text" name="email"><br>

    <label>Password</label>
    <input type="password" name="pass"><br>

    <label>Confirm password</label>
    <input type="password" name="confirmPass"><br>

    <button type="submit">Registrati!</button> <br>

</form>
    <a href="login-admin.jsp"> Oppure loggati</a>
</body>
</html>
