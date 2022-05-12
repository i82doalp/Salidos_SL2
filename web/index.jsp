<%-- 
    Document   : login
    Created on : 12 may 2022, 15:11:46
    Author     : José Manuel Gil Rodríguez
--%>

<%@page import="salidos.entity.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <%
        String strErrorLogin = (String)request.getAttribute("error");
        if (strErrorLogin == null) strErrorLogin = "";
        
        Persona persona = (Persona)session.getAttribute("persona");
        if (persona != null) {
            response.sendRedirect(request.getContextPath() + "/inicio.jsp");
        }
    %>
    <body>
        <h1>Bienvenido</h1><br>
        
        <h2>Inciar sesión</h2>
        <p style="color:red;"><%= strErrorLogin %></p>
        <form method="POST" action="iniciarSesionServlet">
            <label>Email</label>
            <input type="email" name="email" required/>
            <label>Contraseña</label>
            <input type="password" name="pass" required/>            
            <input type="submit" value="Iniciar sesión"/>
        </form>
        
        <h2>Registrarse</h2>
    </body>
</html>
