<%-- 
    Document   : venta
    Created on : 14 may 2022, 20:29:03
    Author     : Pablo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página nueva venta</title>
    </head>
    <body>
        <h2>Por favor, rellene los datos del nuevo objeto que quiere poner en venta</h2>
        
        <form method="POST" action="nuevaVentaServlet">
            <label for="nombre">Nombre : </label>
            <input type="text" name="nombre" id="nombre"/><br>
            <label for="precioS">Precio salida : </label>
            <input type="number" name="precioS" id="precioS"/><br>
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
