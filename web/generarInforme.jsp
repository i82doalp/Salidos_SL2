<%-- 
    Document   : generarInforme
    Created on : 14 may 2022, 11:19:02
    Author     : José Manuel Gil Rodríguez
--%>

<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Generar informe</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        String tabla = (String)request.getAttribute("tabla");
        String informe = (String)request.getAttribute("informeSobre");
    %>
    <body>
        <h1>Generar informe</h1>
        <%
            if (tabla == null) {
        %>
        <form method="POST" action="generarInformeServlet">
            <input type="radio" name="tabla" value="0" required>
            <label>Personas</label>
            <input type="radio" name="tabla" value="1">
            <label>Productos</label>
            <input type="submit" value="Siguiente">
        </form>
        <%
            } else {
        %>
            <h2><%= informe %></h2>
            <%
                if (tabla.equals("0")) {
            %>
                <form method="POST" action="generarInformeServlet">
                    <input type="hidden" name="tabla" value="<%= tabla %>">
                    <p>Sobre: </p><br>
                    <input type="radio" name="columna" value="0" required>
                    <label>Productos vendidos</label>
                    <input type="radio" name="columna" value="1">
                    <label>Productos comprados</label>
                    <p>Orden: </p><br>
                    <input type="radio" name="orden" value="0" required>
                    <label>Ascendente</label>
                    <input type="radio" name="orden" value="1">
                    <label>Descendente</label>
                    <input type="submit" value="Generar informe">
                </form>
            <%
                } else {
            %>
                <form method="POST" action="generarInformeServlet">
                    <input type="hidden" name="tabla" value="<%= tabla %>">
                    <p>Sobre: </p><br>
                    <input type="radio" name="columna" value="2" required>
                    <label>Precio salida</label>
                    <input type="radio" name="columna" value="3">
                    <label>Precio compra</label>
                    <input type="radio" name="columna" value="4">
                    <label>Estado producto</label>
                    <p>Orden: </p><br>
                    <input type="radio" name="orden" value="0" required>
                    <label>Ascendente</label>
                    <input type="radio" name="orden" value="1">
                    <label>Descendente</label>
                    <br>
                    <input type="submit" value="Generar informe">
                </form>
            <%
                }
            %>
        <%
            }
        %>
    </body>
</html>
