<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% User u = (User)session.getAttribute("user");

if(u == null){
    response.sendRedirect("index.jsp");
}

%>

<html>
<head>
    <title>Title</title>
</head>
<body>
Welecome in my home <%=u.getNome()%> <br>

<p>${error}</p> <br>

<p> <a href="/recovery-event">Visualizza tutti gli eventi</a> </p> <br>
<p> <a href="searchEvent.jsp">Effettua una ricerca per zona o genere</a> </p> <br>

<button> <a href="/user-logout">Logout</a></button>

</body>
</html>
