<%-- 
    Document   : adminAgregarPersona
    Created on : 16 may 2022, 17:39:25
    Author     : Cristian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%String strError = (String)request.getAttribute("error");
        if (strError == null) strError = "";
        String correcto = (String)request.getAttribute("correcto");
        if (correcto == null) correcto = "";
        %>
        
        
        <h2>Agregar un usuario</h2>
        <p style="color:red;"><%= strError %></p>
        <p style="color:green;"><%= correcto %></p>
        <form method="POST" action="registrarServlet">
            <label>Email</label>
            <input type="email" name="email_register" required/><br>
            <label>Contraseña</label>
            <input type="password" name="pass_register" required/>  <br>
            <label>Nombre</label>
            <input type="text" name="nombre" required/> <br>
            <label>Apellidos</label>
            <input type="text" name="apellidos" required/> <br>
            <label>Fecha de nacimiento</label>
            <input type="date" name="f_nacimiento" required/><br>
            <label>Domicilio</label>
            <input type="text" name="domicilio" required/> <br>
            <label>Ciudad</label>
            <input type="text" name="ciudad" required/><br>
            
            <select name="rol">
                <option disabled=""selected>Tipo Rol</option>
                <option value="Usuario">Usuario</option>
                <option value="Administrador">Administrador</option>
                <option value="Analista">Analista</option>
                <option value="Marketing">Marketing</option>
                
            </select><br>

            <input type="radio" name="sexo"  value='H'>
            <label>Hombre</label><br>
            <input type="radio" name="sexo"  value='M'>
            <label>Mujer</label><br>
            
            <p>Selecciona algun interes (Opcional)</p>
            <input type="checkbox" name="intereses" value="1">
            <label>Deportes</label><br>
            
            <input type="checkbox" name="intereses" value="2">
            <label>Arte</label><br>
            
            <input type="checkbox" name="intereses" value="3">
            <label>Entretenimiento</label><br>
            
            <input type="checkbox" name="intereses" value="4">
            <label>Tecnologia</label><br>
            
            <input type="checkbox" name="intereses" value="5">
            <label>Musica</label><br>
            
            <input type="submit" value="Registrar usuario"/>
        </form>
        
    </body>
</html>
