<%-- 
    Document   : administrador
    Created on : 12 may 2022, 18:45:16
    Author     : Cristian Alberto Sanchez
--%>

<%@page import="java.util.List"%>
<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administración</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        List<PersonaDTO> listaPersonas = (List)request.getAttribute("listaPersonas");
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
    %>
    <body>
        <h1>Bienvenido administrador</h1>
        <h2>Datos personales</h2>
        <p>
            Nombre: <%= persona.getNombre() %><br>
            Apellidos:  <%= persona.getApellidos() %><br>
            Email:  <%= persona.getEmail() %>
        </p>
        
        <h2>Administración de usuarios</h2>
        <p style="color:red;"><%= strError %></p>
        <%
            if (listaPersonas != null ) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Email</th>
                    <th>Nombre</th>
                    <th>Apellidos</th>
                    <th>Rol</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    for (int i = 0; i < listaPersonas.size(); i++) {
                    
                    if(persona.getIdPersona()!=(listaPersonas.get(i).getIdPersona()))
                    {
                %>
                    <tr>
                        <td><%= listaPersonas.get(i).getIdPersona() %></td>
                        <td><%= listaPersonas.get(i).getEmail() %></td>
                        <td><%= listaPersonas.get(i).getNombre() %></td>
                        <td><%= listaPersonas.get(i).getApellidos() %></td>
                        <td><%= listaPersonas.get(i).getRol() %></td>
                        <td><a href="administrarPersonaServlet?accion=editar&id=<%= listaPersonas.get(i).getIdPersona() %>">Editar</a></td>
                        <td><a href="administrarPersonaServlet?accion=borrar&id=<%= listaPersonas.get(i).getIdPersona() %>">Borrar</a></td>
                        
                    </tr>
                <%
                    }
                 }
                %>
            </tbody>
        </table>
        <%
            }
        %>
    </body>
</html>
