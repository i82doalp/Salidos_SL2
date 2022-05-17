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
        if (persona == null) {
            response.sendRedirect(request.getContextPath());
        }
        
        
    %>
    <body>
        <h1>Bienvenido usuario: <%= persona.getNombre() %></h1>
 
        <%   
        
        ProductoDTO busqueda = (ProductoDTO)session.getAttribute("buscado");

        
        if(busqueda!=null){
        
        %>
        <h3>Resultado de la busqueda</h3>
        
         <table border="1">
            <thead>
                <tr>
                    <td>Id objeto</td>
                    <td>Nombre objeto</td>
                    <td>Precio salida</td>
                    <td>Precio compra</td>
                </tr>
            </thead>
            <tbody>
                <%
                   
                String compra_buscada;

                   if(busqueda.getPrecioCompra()==0){compra_buscada="En venta";}else{compra_buscada= (Float.toString(busqueda.getPrecioCompra())); compra_buscada = compra_buscada +"€";}
                %>
                <tr>
                    <td><%= busqueda.getIdProducto() %></td>
                    <td><%= busqueda.getNombreProducto() %></td>
                    <td><%= busqueda.getPrecioSalida() %>€</td>
                    <td><%= compra_buscada %></td>
                </tr>
                <%
                    
                %>
            </tbody>
        </table>
        
        
         <%   
        
             }
        
        
        %>
        <h3>A continuación se muestran las ventas del cliente : (orden ascendente) </h3><br> 
        
        <form method="post" action="busquedaProductoServlet">
            
            <input type="text" name="filtro" placeholder="Buscar por nombre">
            <input type="hidden" name="tipo" value="ventas">
            <input type="submit" value="BUSCAR">
            
        </form><br>
    
        <table border="1">
            <thead>
                <tr>
                    <td>Id objeto</td>
                    <td>Nombre objeto</td>
                    <td>Precio salida</td>
                    <td>Precio compra</td>
                </tr>
            </thead>
            <tbody>
                <%
                    String compra;
                    
                    for(int i = ventas.size()-1; i>=0; i-- ){
                    
                   if(ventas.get(i).getPrecioCompra()==0){compra="En venta";}else{compra= (Float.toString(ventas.get(i).getPrecioCompra())); compra = compra +"€";}
                %>
                <tr>
                    <td><%= ventas.get(i).getIdProducto() %></td>
                    <td><%= ventas.get(i).getNombreProducto() %></td>
                    <td><%= ventas.get(i).getPrecioSalida() %>€</td>
                    <td><%= compra %></td>
                    <td> <a href="editarProductoServlet?id_objeto=<%= ventas.get(i).getIdProducto() %>">Editar</a></td>
                    <td> <a href="borrarProductoServlet?id_objeto=<%= ventas.get(i).getIdProducto() %>">Borrar</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table><br>
        
            <a href="venta.jsp">NUEVA VENTA</a>
            
            
    </body>
</html>
