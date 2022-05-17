<%-- 
    Document   : verInforme
    Created on : 14 may 2022, 18:44:26
    Author     : José Manuel Gil Rodríguez
--%>

<%@page import="salidos.dto.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page import="salidos.dto.TransaccionDTO"%>
<%@page import="salidos.dto.AnalisisDTO"%>
<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver informe</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        AnalisisDTO analisis = (AnalisisDTO)request.getAttribute("analisis");
        List<TransaccionDTO> transacciones = (List)request.getAttribute("informeTransacciones");
        List<ProductoDTO> productos = (List)request.getAttribute("informeProductos");
     %>
    <body>
        <h1>Informe <%= analisis.getId() %></h1>
        <a href="analisisServlet">Inicio</a>
        <p>Descripción: <%= analisis.getDescripcion() %></p>
        
        <%
            if (transacciones != null || productos != null) {
        %>
            <table border="1">
                <%
                    if (analisis.getTabla() == 0) {
                %>
                <thead>
                    <tr>
                        <%
                            if (analisis.getColumna() == 0) {
                        %>
                        <th>PPRECIO VENTA</th>
                        <%
                            } else {
                        %>
                        <th>PPRECIO COMPRA</th>
                        <%
                            }
                        %>
                        <th>EMAIL</th>
                        <th>NOMBRE</th>
                        <th>PRODUCTO</th>
                    </tr>
                </thead>
                <%
                    } else {
                %>
                    <thead>
                        <tr>
                            <th <% if (analisis.getColumna() == 2) { %> style="color: blue;" <% } %>>PPRECIO SALIDA</th>
                            <th>NOMBRE</th>
                            <th <% if (analisis.getColumna() == 4) { %> style="color: blue;" <% } %>>ESTADO</th>
                            <th <% if (analisis.getColumna() == 3) { %> style="color: blue;" <% } %>>PRECIO COMPRA</th>
                        </tr>
                    </thead>
                <%
                    }
                %>
                <tbody>
                    <%
                        if (analisis.getTabla() == 0) {
                            for (int i = 0; i < transacciones.size(); i++) {
                                if (transacciones.get(i).getPrecioVenta() != null) {
                    %>
                            <tr>
                                <td><%= transacciones.get(i).getPrecioVenta() %></td>
                                <td><%= transacciones.get(i).getPersona().getEmail() %></td>
                                <td><%= transacciones.get(i).getPersona().getNombre() %></td>
                                <td><%= transacciones.get(i).getProducto().getTitulo() %></td>
                            </tr>
                    <%
                                }
                            }
                        } else {
                            for (int i = 0; i < productos.size(); i++) {
                    %>
                            <tr>
                                <td><%= productos.get(i).getPrecioSalida() %></td>
                                <td><%= productos.get(i).getNombreProducto() %></td>
                                <td><%= productos.get(i).getDescripcion() %></td>
                                <td><%= productos.get(i).getPrecioCompra() %></td>
                            </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <h3 style="color: red;">ERROR en la Base de Datos. Consulta con un administrador</h3>
        <%
            }
        %>
    </body>
</html>
