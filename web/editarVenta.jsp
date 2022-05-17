<%-- 
    Document   : editarVenta
    Created on : 16 may 2022, 21:23:50
    Author     : Pablo
--%>

<%@page import="salidos.entity.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar venta</title>
    </head>
    <%
        Producto producto_a_editar = (Producto)request.getAttribute("producto_a_editar");
    %>
    
    
    <body>
        
        <h2>Objeto a editar</h2>
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

                   if(producto_a_editar.getPrecioCompra()==0){compra_buscada="En venta";}else{compra_buscada= (Float.toString(producto_a_editar.getPrecioCompra())); compra_buscada = compra_buscada +"€";}
                %>
                <tr>
                    <td><%= producto_a_editar.getIdProducto() %></td>
                    <td><%= producto_a_editar.getTitulo() %></td>
                    <td><%= producto_a_editar.getPrecioSalida() %>€</td>
                    <td><%= compra_buscada %></td>
                </tr>
                <%
                    
                %>
            </tbody>
        </table><br>
        <form action="modificarProductoServlet" method="POST">
            <input type="hidden" name="id_objeto" value="<%= producto_a_editar.getIdProducto() %>"
            <label for="nombre">Nombre : </label>
            <input type="text" placeholder="<%= producto_a_editar.getTitulo()%>" name="nombre" id="nombre"/><br>
            <label for="precioS">Precio salida : </label>
            <input type="number" placeholder="<%= producto_a_editar.getPrecioSalida() %>" name="precioS" id="precioS"/><br>
            Descripción del producto : <br>
            <input type="radio" name="descripcion" id="descripcion1" value="bueno" />
            <label for="descripcion1">Bueno</label><br>
            <input type="radio" name="descripcion" id="descripcion2" value="mediocre" />
            <label for="descripcion2">Mediocre</label><br>
            <input type="radio" name="descripcion" id="descripcion3" value="pesimo" />
            <label for="descripcion3">Pésimo</label><br>
            Seleccionar intereses a los que puede pertenecer el producto : <br>
            <input type="checkbox" name="interes" id="interes1" value="1"/>
            <label for="interes1">Deportes</label><br>
            <input type="checkbox" name="interes" id="interes2" value="2"/>
            <label for="interes2">Arte</label><br>
            <input type="checkbox" name="interes" id="interes3" value="3"/>
            <label for="interes3">Entretenimiento</label><br>
            <input type="checkbox" name="interes" id="interes4" value="4"/>
            <label for="interes4">Tecnología</label><br>
            <input type="checkbox" name="interes" id="interes5" value="5"/>
            <label for="interes5">Música</label><br>
            <input type="submit" value="Enviar">
            
        </form>
        
        
        
    </body>
</html>
