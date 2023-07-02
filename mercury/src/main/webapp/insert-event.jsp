<%@ page import="model.Azienda" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Azienda a = (Azienda) session.getAttribute("azienda"); %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>INSERT NEW EVENT</h1> <br>

<p>${error}</p> <br>

<form action="event-servlet" method="POST">

    <input type="hidden" value="reg" name="reg">

    <label>Nome evento</label>
    <input type="text" name="name-evento"><br>

    <label>Nome azienda</label>
    <input type="text" name="nome-azienda" value="<%=a.getNomeAzienda()%>"><br>

    <label>Genere</label>
    <input type="text" name="genere"><br>

    <label>Luogo</label>
    <input type="text" name="luogo"><br>

    <label>Prezzo</label>
    <input type="text" name="prezzo"><br>

    <button type="submit">Insert!</button>

</form>

</body>
</html>
