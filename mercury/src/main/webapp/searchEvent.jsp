<%--
  Created by IntelliJ IDEA.
  User: 39351
  Date: 02/07/2023
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Search your event</h1>

<p>${error}</p>

<form action="search-event" method="get">
  <input type="text" name="genere" placeholder="Inserisci il genere" />
  <button type="submit">Cerca</button>
</form>

</body>
</html>
