<%-- 
    Document   : inicio
    Created on : 12 may 2022, 17:26:16
    Author     : gil
--%>

<%@page import="salidos.dto.ProductoDTO"%>
<%@page import="java.util.List"%>
<%@page import="salidos.dto.PersonaDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <%
        PersonaDTO persona = (PersonaDTO)session.getAttribute("persona");
        List<ProductoDTO> ventas = (List<ProductoDTO>)request.getAttribute("ventas");
        String error = "";
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        if (ventas == null){
             error = "No has vendido nada todavia";
        }
        
    %>
    <body>
        <h1>Bienvenido usuario: <%= persona.getNombre() %></h1>
        <h3>A continuación se muestran las ventas del cliente : </h3>
        <p style="color:red"><%= error %></p>
            
        <table>
            <thead>
                <tr>
                    <td>Id objeto</td>
                    <td>Nombre objeto</td>
                    <td>Precio compra</td>
                </tr>
            </thead>
            <tbody>
                <%
                    for(ProductoDTO venta : ventas){
                %>
                <tr>
                    <td><%= venta.getIdProducto() %></td>
                    <td><%= venta.getNombreProducto() %></td>
                    <td><%= venta.getPrecioCompra() %></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
            <%  } %>
    </body>
</html>
