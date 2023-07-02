<%@ page import="model.Azienda" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Evento" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 12:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Azienda a = (Azienda) session.getAttribute("azienda");%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>

<h1>Benvenuto <%=a.getNomeAzienda()%>
</h1><br>

<a href="insert-event.jsp">INSERISCI UN EVENTO</a> <br>
<a href="/recovery-event">TUTTI GLI EVENTI</a> <br>

<button><a href="/azienda-logout">Logout</a></button>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
