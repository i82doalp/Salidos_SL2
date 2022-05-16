<%-- 
    Document   : administrador
    Created on : 12 may 2022, 18:45:16
    Author     : Cristian Alberto Sanchez
--%>

<%@page import="salidos.dto.ProductoDTO"%>
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
        List<ProductoDTO> listaProductos = (List)request.getAttribute("listaProductos");
        String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
        
        String busqueda_incorrecta = (String)session.getAttribute("busqueda_incorrecta");
        if (busqueda_incorrecta == null) busqueda_incorrecta = "";
    %>
    <body>
        <h1>Bienvenido administrador</h1>
        <h2>Datos personales</h2>
        <p>
            Nombre: <%= persona.getNombre() %><br>
            Apellidos:  <%= persona.getApellidos() %><br>
            Email:  <%= persona.getEmail() %>
        </p>
        <td><a href="adminAgregarPersona.jsp">Agregar nuevo usuario</a></td>
        
        
        
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
        
        <h2>Administración de productos</h2>
        
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
        </table><br>

        
        
         <%   
        
             }
        else
        {
        %>
         
        <p style="color:red;"><%= busqueda_incorrecta %></p>
        
        
        <%

        }
        
        
        %>
        <form method="post" action="busquedaProductoServlet">
            
            <input type="text" name="filtro" placeholder="Buscar por nombre del producto">
            <input type="hidden" name="tipo" value="administrador">
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
                    
                    for(int i =0; i<listaProductos.size();i++){
                    
                   if(listaProductos.get(i).getPrecioCompra()==0){compra="En venta";}else{compra= (Float.toString(listaProductos.get(i).getPrecioCompra())); compra = compra +"€";}
                %>
                <tr>
                    <td><%= listaProductos.get(i).getIdProducto() %></td>
                    <td><%= listaProductos.get(i).getNombreProducto() %></td>
                    <td><%= listaProductos.get(i).getPrecioSalida() %>€</td>
                    <td><%= compra %></td>
                    <td> <a href="editarProductoServlet.jsp?">Editar</a></td>
                    <td> <a href="borrarProductoServlet.jsp">Borrar</a></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table><br>
        
        
    </body>
</html>
