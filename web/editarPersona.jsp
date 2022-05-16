<%-- 
    Document   : editarPersona
    Created on : 16 may 2022, 18:41:55
    Author     : Cristian
--%>

<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        PersonaDTO persona_editar = (PersonaDTO)session.getAttribute("persona_editar");
        if (persona_editar == null) {
            response.sendRedirect(request.getContextPath());
        }
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
        String correcto = (String)request.getAttribute("correcto");
        if (correcto == null) correcto = "";
        

%>
        
        
        <h2>Editar Usuario</h2>
        <p style="color:red;"><%= strError %></p>
        <p style="color:green;"><%= correcto %></p>
        <form method="POST" action="editarPersonaServlet">
            <label>Email</label>
            <input type="email" name="email_register" placeholder="<%=persona_editar.getEmail()%> "/><br>
            <label>Contraseña</label>
            <input type="password" name="pass_register" placeholder="<%=persona_editar.getPassword()%> " />  <br>
            <label>Nombre</label>
            <input type="text" name="nombre"  placeholder="<%=persona_editar.getNombre()%> " /> <br>
            <label>Apellidos</label>
            <input type="text" name="apellidos"  placeholder="<%=persona_editar.getApellidos()%> " /> <br>
            <label>Fecha de nacimiento</label>
            <input type="date" name="f_nacimiento"  placeholder="<%=persona_editar.getfNacimiento()%> " /><br>
            <label>Domicilio</label>
            <input type="text" name="domicilio"  placeholder="<%=persona_editar.getDomicilio()%> " /> <br>
            <label>Ciudad</label>
            <input type="text" name="ciudad"  placeholder="<%=persona_editar.getCiudad()%> " /><br>
            
            <select name="rol">
                <option disabled=""selected>Tipo Rol</option>
                <option value="Usuario">Usuario</option>
                <option value="Administrador">Administrador</option>
                <option value="Analista">Analista</option>
                <option value="Marketing">Marketing</option>
                
            </select><br>

                       
            <p>Editar intereses</p>
            <input type="checkbox" name="intereses" value="1">
            <label>Deportes</label><br>
            
            <input type="checkbox" name="intereses" value="2">
            <label>Arte</label><br>
            
            <input type="checkbox" name="intereses" value="3">
            <label>Entretenimiento</label><br>
            
            <input type="checkbox" name="intereses" value="4">
            <label>Tecnologia</label><br>
            
            <input type="checkbox" name="intereses" value="5">
            <label>Musica</label><br><br>
            
            <input type="submit" value="Editar usuario"/>
        </form>
        
    </body>
</html>
