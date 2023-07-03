<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Azienda" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 03/07/2023
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Azienda> aziendaList = (ArrayList<Azienda>) request.getAttribute("aziendaList");

  for (Azienda azienda : aziendaList) {
    String nome = azienda.getNomeAzienda();
    String luogo = azienda.getLuogoAzienda();
    String numero = azienda.getNumeroAzienda();
    String p_iva = azienda.getP_iva();


%>


<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>


<div class="container">
  <div class="card">
    <div class="card-body">
      <h5 class="card-title"><%=nome%>
      </h5>
      <p class="card-text"><%=luogo%>
      </p>
      <p class="card-text"><%=numero%>
      </p>
      <p class="card-text"><%=p_iva%>
    </div>
  </div>
</div>
<%}%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
