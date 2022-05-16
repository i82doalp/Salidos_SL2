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

/**
 *
 * @author gil
 */
@WebServlet(name = "generarInformeServlet", urlPatterns = {"/generarInformeServlet"})
public class generarInformeServlet extends HttpServlet {

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
        
            String tabla = request.getParameter("tabla");
            String columna = request.getParameter("columna");
            String orden = request.getParameter("orden");
            
            
            if (tabla != null && columna != null && orden != null) {
                String descripcion = this.analisisService.generarDescripcion(Integer.parseInt(tabla), Integer.parseInt(columna), Integer.parseInt(orden));
                
                this.analisisService.crearInforme(descripcion, Integer.parseInt(tabla), Integer.parseInt(columna), Integer.parseInt(orden));
                
                response.sendRedirect(request.getContextPath() + "/analisisServlet");
            } else {
                String informe;
                if (tabla.equals("0"))
                    informe = "Informe sobre PERSONAS";
                else
                    informe = "Informe sobre PRODUCTOS";

                request.setAttribute("informeSobre", informe);
                request.setAttribute("tabla", tabla);
                request.getRequestDispatcher("generarInforme.jsp").forward(request, response);
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
