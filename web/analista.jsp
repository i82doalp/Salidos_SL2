<%-- 
    Document   : analista
    Created on : 12 may 2022, 18:45:29
    Author     : gil
--%>

<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
    %>
    <body>
        <h1>Bienvenido analista: <%= persona.getNombre() %></h1>
    </body>
</html>
