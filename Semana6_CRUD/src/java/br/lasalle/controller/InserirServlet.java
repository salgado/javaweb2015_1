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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author salgado
 */
public class InserirServlet extends HttpServlet {

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
            out.println("<title>CRUD-Inserir</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Inserção</h1>");
            
            //cria variavel do tipo Usuario
            Usuario usuario = new Usuario();
            usuario.setLogin(request.getParameter("txtLogin"));
            usuario.setSenha(request.getParameter("txtSenha"));
            
            String resultado = inserir(usuario);
            out.println(resultado);
            
            out.println("<input type='button' value='Voltar' onClick='history.go(-1)'>");
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

    private String inserir(Usuario usuario) {
        //insere no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        boolean result = usuarioDAO.inserir(usuario);
        String HTML;
        
        if (result)
        {
            HTML = "<h2>Inserção realizada com sucesso</h2>";
        }
        else
        {
            HTML = "<h2>Erro na inserção, verifique o Log</h2>";
        }
         
        return HTML;
    }

}
