<%-- 
    Document   : personas
    Created on : 11 may 2022, 17:45:59
    Author     : gil
--%>

<%@page import="java.util.List"%>
<%@page import="salidos.entity.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        List <Persona> personas = (List)request.getAttribute("personas");
    %>
    <body>
        <h1>Lista Personas</h1>
        
        <%
            for (int i = 0; i < personas.size(); i++) {
        %>    
            <%= personas.get(i).getEmail() %>
        <%
            }
        %>
    </body>
</html>
