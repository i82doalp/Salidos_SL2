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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import salidos.dto.PersonaDTO;
import salidos.entity.Persona;
import salidos.service.PersonaService;

/**
 *
 * @author Cristian
 */
@WebServlet(name = "filtradoPersonaServlet", urlPatterns = {"/filtradoPersonaServlet"})
public class filtradoPersonaServlet extends HttpServlet {

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
          HttpSession session = request.getSession();
          List <Persona> listaPersonas = personaService.listaPersonasEntity();
          List <PersonaDTO> listaPersonasDTO= new ArrayList<PersonaDTO>();
          String filtrado = request.getParameter("filtro");
          
          switch(filtrado)
            {
                case "idMayorMenor" -> {
                    Collections.sort(listaPersonas, Collections.reverseOrder());
                    for (int i =0; i<listaPersonas.size();i++)
                    {
                        listaPersonasDTO.add(listaPersonas.get(i).toDTO());
                    }
                    
                    session.setAttribute("listaPersonasFiltrada", listaPersonasDTO);
                    request.getRequestDispatcher("administradorServlet").forward(request, response);
             }
                case "idMenorMayor" -> {
                    Collections.sort(listaPersonas);
                    for (int i =0; i<listaPersonas.size();i++)
                    {
                        listaPersonasDTO.add(listaPersonas.get(i).toDTO());
                    }
                    
                    session.setAttribute("listaPersonasFiltrada", listaPersonasDTO);
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
