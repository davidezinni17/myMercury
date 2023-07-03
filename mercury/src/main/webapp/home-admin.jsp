<%@ page import="model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 03/07/2023
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Admin admin = (Admin) session.getAttribute("admin");

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
CONGRATULAZIONI TI SEI LOGGATO COME ADMIN <br>
Benvenuto <%=admin.getUsername()%> <br> <br> <br> <br> <br>

<a href="/admin-recoveryUser">VISUALIZZA TUTTI GLI UTENTI REGISTRATI</a> <br>
<a href="/admin-recoveryEvent">VISUALIZZA TUTTI GLI EVENTI</a> <br>
<a href="/admin-recoveryAzienda">VISUALIZZA TUTTE LE AZIENDE REGISTRATE</a> <br>
<a href="/admin-recoveryAdmin">VISUALIZZA TUTTE ADMIN REGISTRATI</a> <br>


<button><a href="/logout-admin">Logout</a></button>
</body>
</html>
