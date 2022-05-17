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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import salidos.dto.ProductoDTO;
import salidos.entity.Producto;
import salidos.service.ProductoService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "filtradoProductoServlet", urlPatterns = {"/filtradoProductoServlet"})
public class filtradoProductoServlet extends HttpServlet {

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
        
       
        
          HttpSession session = request.getSession();
          List <Producto> listaProductos = productoService.getAllProductosEntity();
          List <ProductoDTO> listaProductosDTO= new ArrayList<ProductoDTO>();
          String filtrado = request.getParameter("filtro");
          
          switch(filtrado)
            {
                case "idMayorMenor" -> {
                    Collections.sort(listaProductos, Collections.reverseOrder());
                    for (int i =0; i<listaProductos.size();i++)
                    {
                        listaProductosDTO.add(listaProductos.get(i).toDTO());
                    }
                    
                    session.setAttribute("listaProductosFiltrada", listaProductosDTO);
                    request.getRequestDispatcher("administradorServlet").forward(request, response);
             }
                case "idMenorMayor" -> {
                    Collections.sort(listaProductos);
                    for (int i =0; i<listaProductos.size();i++)
                    {
                        listaProductosDTO.add(listaProductos.get(i).toDTO());
                    }
                    
                    session.setAttribute("listaProductosFiltrada", listaProductosDTO);
                    request.getRequestDispatcher("administradorServlet").forward(request, response);
                    
             }
                
                default     ->{
                
                    
                request.getRequestDispatcher("administradorServlet").forward(request, response);
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
