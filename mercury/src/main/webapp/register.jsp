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

<h1>USER REGISTER</h1> <br>

<p>${error}</p> <br>
<form action="/user-register" method="post">
  <input type="hidden" value="reg" name="reg">

  <label>Nome </label>
  <input type="text" name="name"><br>

  <label>Cognome</label>
  <input type="text" name="surname"><br>

  <label>Email</label>
  <input type="text" name="email"><br>

  <label>Età</label>
  <input type="text" name="age"><br>

  <label>Password</label>
  <input type="password" name="pass"><br>

  <label>Confirm password</label>
  <input type="password" name="confirmPass"><br>

  <button type="submit">Registrati!</button>

</form>


</body>
</html>
