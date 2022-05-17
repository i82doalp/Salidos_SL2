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
import salidos.dto.PersonaDTO;
import salidos.service.PersonaService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "busquedaPersonaServlet", urlPatterns = {"/busquedaPersonaServlet"})
public class busquedaPersonaServlet extends HttpServlet {

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
        
        
        String email = request.getParameter("email_filtro");
        PersonaDTO persona_buscada= personaService.encontrarPorEmail(email);
        HttpSession session = request.getSession();
        
        if (persona_buscada==null)
        {
            String busqueda_incorrecta_pers = "Busqueda Incorrecta";
            session.setAttribute("buscado_persona", null);
            session.setAttribute("busqueda_incorrecta_pers", busqueda_incorrecta_pers);
                
            response.sendRedirect(request.getContextPath() + "/administradorServlet");
                
                
        }
        else{
        String buscado = request.getParameter("busqueda");
      
            if(buscado!=null)
            {
                session.setAttribute("buscado_persona", null);
                response.sendRedirect(request.getContextPath() + "/administradorServlet");
            }
            else
            {
                session.setAttribute("buscado_persona", persona_buscada);
                response.sendRedirect(request.getContextPath() + "/administradorServlet?busqueda=1");
                
            }
        
        
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
