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
import salidos.dto.PersonaDTO;
import salidos.service.PersonaService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "administrarPersonaServlet", urlPatterns = {"/administrarPersonaServlet"})
public class administrarPersonaServlet extends HttpServlet {

    
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
        response.setContentType("text/html;charset=UTF-8");
        
        String id = request.getParameter("id");
        String accion= request.getParameter("accion");
        
        PersonaDTO persona= personaService.encontrarPorId(Integer.parseInt(id));
        
        System.out.println("OYEEEEEEEE que el email es"+persona.toEntity().getIdPersona());
        
        if(persona!= null)
        {
            if(accion.contentEquals("editar"))
            {
                request.setAttribute("personaDTO", persona);
                request.getRequestDispatcher("editarPersona.jsp").forward(request, response);
                
            }
            else
            {
                this.personaService.deletePersona(Integer.parseInt(id));
                response.sendRedirect(request.getContextPath() +  "/administradorServlet");

            }
        }
        else
        {
            String strError = "Ha ocurrido un error";
            request.setAttribute("error", strError);
            request.getRequestDispatcher("administradorServlet").forward(request, response);
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
