/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.controller;

import com.av2.gabriel.sousa.dao.CompraDAO;
import com.av2.gabriel.sousa.dao.ProdutoDAO;
import com.av2.gabriel.sousa.dao.UsuarioDAO;
import com.av2.gabriel.sousa.model.Compra;
import com.av2.gabriel.sousa.model.Produto;
import com.av2.gabriel.sousa.model.Usuario;
import com.av2.gabriel.sousa.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "Pedidos", urlPatterns = {"/pedidos"})
public class Pedidos extends HttpServlet {

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
        
        //pega usuario logado na sessao
        Usuario usuarioLogado = (Usuario) request.getSession().getAttribute("usuarioLogado");
        
        String action = request.getParameter("act");
        CompraDAO compraDao = new CompraDAO();
        String paginaDestino = "";
        List<Compra> compras = new ArrayList<Compra>();
        
        if(Util.isBlankOrNull(action)) {
            
            //valida autenticacao
            if(usuarioLogado == null) {
                paginaDestino = "403.jsp";
            } else {
                paginaDestino = "listaPedido.jsp";
                
                //ADMIN
                if("ADMIN".equals(usuarioLogado.getTipo())) {
                    compras = compraDao.findAll();
                } else { //USUARIO
                    compras = compraDao.findAllByUsuarioId(usuarioLogado.getId());
                }

                request.getSession().setAttribute("compras", compras);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
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
