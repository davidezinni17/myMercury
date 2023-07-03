<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 03/07/2023
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Admin> adminList = (ArrayList<Admin>) request.getAttribute("adminList");

  for (Admin admin : adminList) {
    String name = admin.getName();
    String surname = admin.getSurname();
    String username = admin.getUsername();
    String email = admin.getEmail();
    String pass = admin.getPassword();


%>
<html>
<head>
    <title>Title</title>
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
      <p class="card-text"><%=surname%>
      </p>
      <p class="card-text"><%=username%>
      </p>
      <p class="card-text"><%=email%>
      </p>
      <p class="card-text"><%=pass%>
      </p>
    </div>
  </div>
</div>

<% } %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
