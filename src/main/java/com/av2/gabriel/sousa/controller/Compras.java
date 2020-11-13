/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.controller;

import com.av2.gabriel.sousa.dao.CompraDAO;
import com.av2.gabriel.sousa.dao.ProdutoDAO;
import com.av2.gabriel.sousa.model.Compra;
import com.av2.gabriel.sousa.model.Produto;
import com.av2.gabriel.sousa.model.Usuario;
import com.av2.gabriel.sousa.util.Util;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "Compras", urlPatterns = {"/compras"})
public class Compras extends HttpServlet {

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
        ProdutoDAO produtoDao = new ProdutoDAO();
        String contextPath = request.getContextPath();
        String paginaDestino = "";
        
        if(Util.isBlankOrNull(action)) { //default
            populaProdutos(request, produtoDao);
            
            //valida autenticacao
            if(usuarioLogado == null) {
                paginaDestino = "403.jsp";
            } else {
                paginaDestino = "compra.jsp";
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
        } else if("COMPRA".equals(action)) {
            String msgErro = "";
            String nome = request.getParameter("nome");
            String idProduto = request.getParameter("id-produto");
            String preco = request.getParameter("preco");
            String quantidade = request.getParameter("quantidade");
            //PEGA DATA DA COMPRA
            java.util.Date dataUtil = new java.util.Date();
            java.sql.Date dataCompra = new java.sql.Date(dataUtil.getTime());
            
            if(Util.isBlankOrNull(quantidade)) {
                msgErro = "Informe a quantidade que deseja do produto "+nome+"!";
                paginaDestino = "compras.jsp";
            }
            
            //calcula valor da compra
            Double valorcompra = Double.valueOf(preco) * Long.valueOf(quantidade);
            
            //cria compra
            Compra compra = new Compra();
            compra.setIdUsuario(usuarioLogado.getId());
            compra.setIdProduto(Long.valueOf(idProduto));
            compra.setDataCompra(dataCompra);
            compra.setQuantidade(Long.valueOf(quantidade));
            compra.setValorCompra(valorcompra);
                    
            compraDao.create(compra);
            
            if(!Util.isBlankOrNull(msgErro)) {
                request.setAttribute("mensagemErro", msgErro);
            } else {
                request.setAttribute("mensagemSucesso", "Compra realizada com sucesso! Aguarde a confirmação do pagamento em algumas horas!");
                paginaDestino = "listaPedido.jsp";
            }
            
            List<Compra> compras = compraDao.findAllByUsuarioId(usuarioLogado.getId());
            request.getSession().setAttribute("compras", compras);
            
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
        }
    }
    
    public void populaProdutos(HttpServletRequest request, ProdutoDAO produtoDao) {
        List<Produto> produtos = produtoDao.findAll();
        if(!produtos.isEmpty()) {
            request.setAttribute("produtos", produtos);
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
