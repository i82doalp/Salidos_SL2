<%-- 
    Document   : editarInforme
    Created on : 14 may 2022, 16:16:00
    Author     : José Manuel Gil Rodríguez
--%>

<%@page import="salidos.dto.PersonaDTO"%>
<%@page import="salidos.dto.AnalisisDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar informe</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        AnalisisDTO analisis = (AnalisisDTO)request.getAttribute("analisis");
        String informe = (String)request.getAttribute("informe");
    %>
    <body>
        <h1>Editar informe sobre <%= informe %></h1>
        <form method="POST" action="">
            <input type="hidden" name="id" value="<%= analisis.getId() %>">
            <input type="hidden" name="tabla" value="<%= analisis.getTabla() %>">
            <%
                if (analisis.getTabla() == 0) {
            %>
                <p>Sobre: </p><br>
                <input type="radio" name="columna" value="0" <% if (analisis.getColumna()==0) { %> checked <% } %> required>
                <label>Productos vendidos</label>
                <input type="radio" name="columna" value="1" <% if (analisis.getColumna()==1) { %> checked <% } %>>
                <label>Productos comprados</label>
            <%
                } else {
            %>
                <p>Sobre: </p><br>
                <input type="radio" name="columna" value="2" <% if (analisis.getColumna()==2) { %> checked <% } %> required>
                <label>Precio salida</label>
                <input type="radio" name="columna" value="3" <% if (analisis.getColumna()==3) { %> checked <% } %>>
                <label>Precio compra</label>
                <input type="radio" name="columna" value="4" <% if (analisis.getColumna()==4) { %> checked <% } %>>
                <label>Estado producto</label>
            <%
                }
            %>
            <p>Orden: </p><br>
            <input type="radio" name="orden" value="0" <% if (analisis.getOrden()==0) { %> checked <% } %> required>
            <label>Ascendente</label>
            <input type="radio" name="orden" value="1" <% if (analisis.getOrden()==1) { %> checked <% } %>>
            <label>Descendente</label>
            <br><br>
            <label>Descripción</label>
            <br>
            <textarea type="text" name="descripcion" rows="5" col="12" required><%= analisis.getDescripcion() %></textarea>
            <br><br>
            <input type="submit" value="Editar informe">
        </form>
    </body>
</html>
