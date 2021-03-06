/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package salidos.servlet;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import salidos.dto.PersonaDTO;
import salidos.dto.ProductoDTO;
import salidos.service.PersonaService;
import salidos.service.ProductoService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "administradorServlet", urlPatterns = {"/administradorServlet"})
public class administradorServlet extends HttpServlet {

    @EJB PersonaService personaService;
    @EJB ProductoService productoService;
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
        
        List <PersonaDTO> listaPersonasDTO = personaService.listaPersonas();
        List <ProductoDTO> listaProductosDTO = productoService.getAllProductos();
        HttpSession session = request.getSession();

        if (listaPersonasDTO == null || listaPersonasDTO.isEmpty() || listaProductosDTO == null || listaProductosDTO.isEmpty()) {
                String strError = "No hay personas";
                request.setAttribute("error", strError);
                request.getRequestDispatcher("administrador.jsp").forward(request, response);
            } else {
                
                List <ProductoDTO> listaProductosFiltrada = (List <ProductoDTO>) session.getAttribute("listaProductosFiltrada");
                List <PersonaDTO> listaPersonasFiltrada = (List <PersonaDTO>) session.getAttribute("listaPersonasFiltrada");

                if(listaProductosFiltrada==null && listaPersonasFiltrada==null ){
                    request.setAttribute("listaProductos", listaProductosDTO);
                    request.setAttribute("listaPersonas", listaPersonasDTO);
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                }
                else 
                {
                   if(listaProductosFiltrada!=null){
                    request.setAttribute("listaProductos", listaProductosFiltrada);
                    request.setAttribute("listaPersonas", listaPersonasDTO);
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                   }
                   else
                   {
                    request.setAttribute("listaPersonas", listaPersonasFiltrada);
                    request.setAttribute("listaProductos", listaProductosDTO);
                    request.getRequestDispatcher("administrador.jsp").forward(request, response);
                   }
                    
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
