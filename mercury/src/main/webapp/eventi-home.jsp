<%@ page import="model.Evento" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Evento> eventList = (ArrayList<Evento>) request.getAttribute("newEventList");

    for (Evento evento : eventList) {
        String name = evento.getName();
        String azienda = evento.getNomeAzienda();
        String genere = evento.getGenere();
        String luogo = evento.getLuogo();
        String prezzo = evento.getPrezzo();
%>
<html>
<head>
    <title>All event</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
Tutti gli eventi <br>

<div class="container">
    <div class="card">
        <div class="card-body">
            <h5 class="card-title"><%=name%>
            </h5>
            <p class="card-text"><%=azienda%>
            </p>
            <p class="card-text"><%=genere%>
            </p>
            <p class="card-text"><%=luogo%>
            </p>
            <p class="card-text"><%=prezzo%>
            </p>
        </div>
    </div>
</div>

<% } %>

<p><a href="/check-session">Ritorna alla home</a> <br>
    <!-- <a href="/check-session"> o inserisci un evento</a> -->
</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
