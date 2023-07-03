<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 03/07/2023
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Login Admin</h1>

<p>${error}</p>

<form action="/register-admin" method="get">
    <input type="hidden" value="reg" name="reg">

    <label>UserName</label>
    <input type="text" name="username"><br>

    <label>Email</label>
    <input type="text" name="email"><br>

    <label>Password</label>
    <input type="password" name="pass"><br>

    <button type="submit">Login!</button>

</form> <br>

<a href="register-admin.jsp">Vuoi diventare un admin?</a>

</body>
</html>
