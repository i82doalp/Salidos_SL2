/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package salidos.servlet;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import salidos.dao.PersonaFacade;
import salidos.dto.PersonaDTO;
import salidos.entity.Persona;
import salidos.service.PersonaService;

/**
 *
 * @author cristian
 */
@WebServlet(name = "registrarServlet", urlPatterns = {"/registrarServlet"})
public class registrarServlet extends HttpServlet {

    @EJB PersonaService personaService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            
        
        String email = request.getParameter("email_register");
        String pass = request.getParameter("pass_register"); 
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos"); 
        String domicilio = request.getParameter("domicilio"); 
        String ciudad = request.getParameter("ciudad"); 
        String fecha_nacimiento = request.getParameter("f_nacimiento"); 
        String sexo = request.getParameter("sexo"); 
        String rol = "Usuario";
        float monedero = 0;
        
        //Si ha recibido null es que no lo ha encontrado por lo que procedemos a registrar
        PersonaDTO personafacade = this.personaService.comprobarCredenciales(email, pass);
        if (personafacade==null)
        {
            Persona persona = new Persona();
            
            persona.setEmail(email);
            persona.setPassword(pass);
            persona.setNombre(nombre);
            persona.setApellidos(apellidos);
            persona.setDomicilio(domicilio);
            persona.setCiudad(ciudad);
            persona.setRol(rol);
            persona.setMonedero(monedero);
            
            char sex =sexo.charAt(0); //Conversion a char
            persona.setSexo(sex);
            
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha_nac = null;
             try 
             {
                 fecha_nac = formato.parse(fecha_nacimiento);
             } 
            catch (ParseException ex) 
            {
               
            }
            
            
            persona.setFNacimiento(fecha_nac);
            
            
             
             personaService.registrarUsuario(persona);
             
             
            String correcto = "USUARIO CORRECTAMENTE REGISTRADO!! Inicia sesión";
            request.setAttribute("correcto", correcto);
            request.getRequestDispatcher("").forward(request, response);            

            
        }
        else
        {
            
            String strError = "El email ya se encuentra registrado";
            request.setAttribute("error_res", strError);
            request.getRequestDispatcher("").forward(request, response);
            

        }

        
        
                  

        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    
}