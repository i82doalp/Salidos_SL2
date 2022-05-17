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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import salidos.dto.PersonaDTO;
import salidos.entity.Interes;
import salidos.entity.Persona;
import salidos.service.PersonaService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "editarPersonaServlet", urlPatterns = {"/editarPersonaServlet"})
public class editarPersonaServlet extends HttpServlet {

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
        
        String identifier = request.getParameter("id");
        int id = Integer.parseInt(identifier);
        String email = request.getParameter("email");
        String pass = request.getParameter("pass"); 
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos"); 
        String domicilio = request.getParameter("domicilio"); 
        String ciudad = request.getParameter("ciudad"); 
        String fecha_nacimiento = request.getParameter("f_nacimiento"); 
        String sexo = request.getParameter("sexo"); 
        char sex =sexo.charAt(0); //Conversion a char
        String rol = request.getParameter("rol");
        String[] i = request.getParameterValues("intereses");
        
        
        List<Interes> interes_persona= this.personaService.retornarListaIntereses(i);
       
            
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = null;
         try 
         {
             fecha_nac = formato.parse(fecha_nacimiento);
         } 
        catch (ParseException ex) 
        {

        }
        this.personaService.modificarPersona(id, email, pass, nombre, 
                apellidos, domicilio, ciudad, fecha_nac, sex, rol, interes_persona);
                        response.sendRedirect(request.getContextPath() + "/administradorServlet");

        
        
        
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
