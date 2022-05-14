<%-- 
    Document   : analista
    Created on : 12 may 2022, 18:45:29
    Author     : José Manuel Gil Rodríguez
--%>

<%@page import="salidos.dto.AnalisisDTO"%>
<%@page import="java.util.List"%>
<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analista</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        List<AnalisisDTO> listaAnalisis = (List)request.getAttribute("listaAnalisis");
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
    %>
    <body>
        <h1>Bienvenido analista</h1>
        <h2>Datos personales</h2>
        <p>
            Nombre: <%= persona.getNombre() %><br>
            Apellidos:  <%= persona.getApellidos() %><br>
            Email:  <%= persona.getEmail() %>
        </p>
        <a href="generarInforme.jsp">Generar informe</a>
        <h2>Informes generados</h2>
        <p style="color:red;"><%= strError %></p>
        <%
            if (listaAnalisis != null ) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>DESCRIPCIÓN</th>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td><a href="#">Ver</a></td>
                    <td><a href="#">Editar</a></td>
                    <td><a href="#">Borrar</a></td>
                </tr>
            </tbody>
        </table>
        <%
            }
        %>
    </body>
</html>
