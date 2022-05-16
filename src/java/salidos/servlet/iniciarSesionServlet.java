/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package salidos.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import salidos.dto.PersonaDTO;
import salidos.dto.ProductoDTO;
import salidos.entity.Producto;
import salidos.service.PersonaService;
import salidos.service.ProductoService;

/**
 *
 * @author José Manuel Gil Rodríguez
 */
@WebServlet(name = "iniciarSesionServlet", urlPatterns = {"/iniciarSesionServlet"})
public class iniciarSesionServlet extends HttpServlet {

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
        
            
            
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            
            PersonaDTO persona = this.personaService.comprobarCredenciales(email, pass);
            

            /*
            List<ProductoDTO> ventas = this.ps.getVentas(persona.getIdPersona());
            
            for(ProductoDTO p : ventas){
                System.out.println(p.getNombreProducto());
            }
            */

            
            HttpSession session = request.getSession();
            session.setAttribute("persona", persona);
            

            //request.setAttribute("ventas", ventas);

            
            if (persona == null) {
                String strError = "El usuario o la clave son incorrectos";
                request.setAttribute("error", strError);
                request.getRequestDispatcher("").forward(request, response);
            } else if (persona.getRol().equals("Administrador")) {
                response.sendRedirect(request.getContextPath() + "/administradorServlet");
            } else if (persona.getRol().equals("Analista")) {
                response.sendRedirect(request.getContextPath() + "/analisisServlet");
            } else if (persona.getRol().equals("Marketing")) {
                response.sendRedirect(request.getContextPath() + "/marketing.jsp");
            } else {
                response.sendRedirect(request.getContextPath() + "/ventasServlet?id="+persona.getIdPersona());
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
