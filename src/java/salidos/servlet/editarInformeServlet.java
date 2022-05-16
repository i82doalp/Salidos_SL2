/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package salidos.servlet;

import jakarta.ejb.EJB;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import salidos.service.AnalisisService;
import salidos.dto.AnalisisDTO;

/**
 *
 * @author gil
 */
@WebServlet(name = "editarInformeServlet", urlPatterns = {"/editarInformeServlet"})
public class editarInformeServlet extends HttpServlet {

    @EJB AnalisisService analisisService;
    
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
        
            String id = request.getParameter("id");
            String tabla = request.getParameter("tabla");
            String columna = request.getParameter("columna");
            String orden = request.getParameter("orden");
            String descripcion = request.getParameter("descripcion");
            
            if (tabla == null) {
                AnalisisDTO analisis = this.analisisService.buscarAnalisis(Integer.parseInt(id));
                
                String informe;
                if (analisis.getTabla() == 0)
                    informe = "Personas";
                else
                    informe = "Productos";
                
                request.setAttribute("informe", informe);
                request.setAttribute("analisis", analisis);
                request.getRequestDispatcher("editarInforme.jsp").forward(request, response);
            } else {
                this.analisisService.modificarInforme(Integer.parseInt(id), descripcion, Integer.parseInt(tabla), Integer.parseInt(columna), Integer.parseInt(orden));
                
                response.sendRedirect(request.getContextPath() + "/analisisServlet");
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
