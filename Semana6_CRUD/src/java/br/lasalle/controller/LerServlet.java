/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.controller;

import br.lasalle.BO.Usuario;
import br.lasalle.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salgado
 */
public class LerServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado Lista Usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resultado Lista Usuario</h1>");
            
            String result = lerUsuarios();
            out.println(result);
            
            out.println("</body>");
            out.println("</html>");
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

    private String lerUsuarios() {
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ArrayList<Usuario> lista = usuarioDAO.ler();
        String HTML = "";

        HTML = HTML + "<table>";
        HTML = HTML + "<tr>";
        HTML = HTML + "<td>Login</td><td>Senha</td>";
        HTML = HTML + "</tr>";

        for(int i=0; i< lista.size(); i++)
        {
            HTML = HTML + "<tr>";

            HTML = HTML + "<td>";
            HTML = HTML + lista.get(i).getLogin();
            HTML = HTML + "</td>";
            HTML = HTML + "<td>";
            HTML = HTML + lista.get(i).getSenha();
            HTML = HTML + "</td>";

            HTML = HTML + "</tr>";
            
        }

        HTML = HTML + "<table>";
        
        log(HTML);

        return HTML;
        
    }

}
