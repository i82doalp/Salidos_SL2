<%-- 
    Document   : login
    Created on : 12 may 2022, 15:11:46
    Author     : José Manuel Gil Rodríguez
    Author     : Cristian Alberto Sanchez
--%>

<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Inicio</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <%
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
        
        String strError_res = (String)request.getAttribute("error_res");
        if (strError_res == null) strError_res = "";
        
        String correct = (String)request.getAttribute("correcto");
        if (correct == null) correct = "";
        
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona != null) {
            response.sendRedirect(request.getContextPath() + "/inicio.jsp");
        }
    %>
    <body>
        <h1>Bienvenido</h1><br>
        
        <h2>Inciar sesión</h2>
        <p style="color:red;"><%= strError %></p>
        <p style="color:greenyellow;"><%= correct %></p>
        <form method="POST" action="iniciarSesionServlet">
            <label>Email</label>
            <input type="email" name="email" required/>
            <label>Contraseña</label>
            <input type="password" name="pass" required/>            
            <input type="submit" value="Iniciar sesión"/>
        </form>
        
        
        
        <h2>¿No estás registrado? ¡Hazlo ahora!</h2>
        <p style="color:red;"><%= strError_res %></p>
        <form method="POST" action="registrarServlet">
            <label>Email</label>
            <input type="email" name="email_register" required/><br>
            <label>Contraseña</label>
            <input type="password" name="pass_register" required/>  <br>
            <label>Nombre</label>
            <input type="text" name="nombre" required/> <br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" required/> <br>
            <label>Fecha de nacimiento</label>
            <input type="date" name="f_nacimiento" required/><br>
            <label>Domicilio</label>
            <input type="text" name="domicilio" required/> <br>
            <label>Ciudad</label>
            <input type="text" name="ciudad" required/><br>
            
            <input type="radio" name="sexo"  value='H'>
            <label>Hombre</label><br>
            <input type="radio" name="sexo"  value='M'>
            <label>Mujer</label><br>
            
            <input type="submit" value="Registrate"/>
        </form>
        
    </body>
</html>
