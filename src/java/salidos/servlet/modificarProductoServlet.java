/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package salidos.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import salidos.dto.PersonaDTO;
import salidos.entity.Interes;
import salidos.entity.Persona;
import salidos.entity.Producto;
import salidos.service.InteresService;
import salidos.service.ProductoService;

/**
 *
 * @author Pablo
 */
@WebServlet(name = "modificarProductoServlet", urlPatterns = {"/modificarProductoServlet"})
public class modificarProductoServlet extends HttpServlet {

    @EJB InteresService interesservice;
    @EJB ProductoService productoservice;
    
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
        
        
        HttpSession sesion = request.getSession();
        PersonaDTO pers = (PersonaDTO)sesion.getAttribute("persona");
        
        int id_objeto = (Integer.parseInt(request.getParameter("id_objeto")));
        
        Producto p = this.productoservice.buscarPorId(id_objeto);
        
        
        String nombre = request.getParameter("nombre");
        float precio_salida = Float.valueOf(request.getParameter("precioS")); 
        String descripcion = request.getParameter("descripcion");
        String[] i = request.getParameterValues("interes");
        List<Interes> intereses = this.interesservice.getIntereses(i);
       
       this.productoservice.productoModificado(p.getIdProducto(),nombre,precio_salida,descripcion,intereses);
       
       request.getRequestDispatcher("ventasServlet?id="+pers.getIdPersona()).forward(request, response);
        
        
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
