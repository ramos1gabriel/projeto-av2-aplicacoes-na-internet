/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.controller;

import com.av2.gabriel.sousa.dao.ProdutoDAO;
import com.av2.gabriel.sousa.model.Produto;
import com.av2.gabriel.sousa.util.Util;
import java.io.IOException;
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
@WebServlet(name = "Produtos", urlPatterns = {"/produtos"})
public class Produtos extends HttpServlet {

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
        
        String action = request.getParameter("act");
        ProdutoDAO produtoDao = new ProdutoDAO();
        String contextPath = request.getContextPath();
        String paginaDestino = "";
        
        if(Util.isBlankOrNull(action)) { //default
            
            populaProdutos(request, produtoDao);
            paginaDestino = "listaProduto.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
            
        } else if("CADASTRO".equals(action)) {
            
            String id = request.getParameter("id");
            String nome = request.getParameter("nome");
            String preco = request.getParameter("preco");
            String descricao = request.getParameter("descricao");
            String url = request.getParameter("url");
            
            String msgErro = "";
            String msgSucesso = "";
            
            //validacao
            if(Util.isBlankOrNull(nome)){
                msgErro += "Preencha o campo nome!\n";
            }
            if(Util.isBlankOrNull(preco)){
                msgErro += "Preencha o campo preço!\n";
            }
            if(Util.isBlankOrNull(descricao)){
                msgErro += "Preencha o campo descrição!\n";
            }
            /*if(Util.isBlankOrNull(url)){
                msgErro += "Preencha o campo URL imagem!\n";
            }*/
            
            if(Util.isBlankOrNull(id)) { //CREATE
                if(!Util.isBlankOrNull(nome) && !Util.isBlankOrNull(preco) && !Util.isBlankOrNull(descricao)) { //&& !Util.isBlankOrNull(url)
                    produtoDao.create(new Produto(nome, Double.valueOf(preco), descricao, url));
                    msgSucesso = "Cadastro criado com sucesso!";
                }
                paginaDestino = "cadastroProduto.jsp";
            } else { //UPDATE
                if(!Util.isBlankOrNull(nome) && !Util.isBlankOrNull(preco) && !Util.isBlankOrNull(descricao)) { //&& !Util.isBlankOrNull(url)
                    produtoDao.update(new Produto(Long.valueOf(id), nome, Double.valueOf(preco), descricao, url));
                    populaProdutos(request, produtoDao);
                    paginaDestino = "listaProduto.jsp";
                }
            }
            
            if(!Util.isBlankOrNull(msgErro)) {
                request.setAttribute("mensagemErro", msgErro);
            } else {
                request.setAttribute("mensagemSucesso", msgSucesso);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
            
        } else if("EDITAR".equals(action)) {
            
            String id = request.getParameter("id");
            Produto produto = produtoDao.findbyId(Long.valueOf(id));
            if(produto != null) {
                request.setAttribute("produto", produto);
                paginaDestino = "cadastroProduto.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
            
        } else if("EXCLUIR".equals(action)) {
            
            String id = request.getParameter("id");
            if(!Util.isBlankOrNull(id)) {
                produtoDao.remove(Long.valueOf(id));
            }
            response.sendRedirect(contextPath+"/produtos");
            
        }
    }
    
    public void populaProdutos(HttpServletRequest request, ProdutoDAO produtoDao) {
        HttpSession session = request.getSession();
        List<Produto> produtos = produtoDao.findAll();
        if(!produtos.isEmpty()) {
            session.setAttribute("produtos", produtos);
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
