<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 01/07/2023
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Login user</h1>

<p>${error}</p>

<form action="/user-login" method="get">
    <input type="hidden" value="reg" name="reg">

    <label>UserName</label>
    <input type="text" name="name"><br>

    <label>Email</label>
    <input type="text" name="email"><br>

    <label>Password</label>
    <input type="password" name="pass"><br>

    <button type="submit">Login!</button>

</form> <br>

<a href="register.jsp">Registrati</a>
</body>
</html>
