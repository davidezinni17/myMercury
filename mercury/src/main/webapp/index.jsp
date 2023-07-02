<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Welcome in mercury, your assistant for all events!!</h1><br>
<a href="register.jsp">Registrati per ricevere info sugli eventi</a> <br>
<a href="register-azienda.jsp">Registrati se sei un azienda</a> <br>
<a href="login.jsp">Login user</a> <br>
<a href="login-azienda.jsp">Login azienda</a> <br>
<br>
<br>
<br>
<!-- Ricorda che per far visualizzare tutti gli eventi bisogna far riferimento ad una servlet
 che esegue prima la chiamata get al server e poi li manda tramite il setAttribute ad una jsp -->
<a href="/recovery-event">VAI A TUTTI GLI EVENTI</a>

</body>
</html>