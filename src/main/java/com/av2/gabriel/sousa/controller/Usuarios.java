/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.controller;

import com.av2.gabriel.sousa.dao.UsuarioDAO;
import com.av2.gabriel.sousa.model.Usuario;
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
@WebServlet(name = "Usuarios", urlPatterns = {"/usuarios"})
public class Usuarios extends HttpServlet {

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
        UsuarioDAO usuarioDao = new UsuarioDAO();
        String contextPath = request.getContextPath();
        String paginaDestino = "";
        
        if(Util.isBlankOrNull(action)) { //default
            populaUsuarios(request, usuarioDao);
            paginaDestino = "listaUsuario.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
        } else if("CADASTRO".equals(action)) {
            String nome = request.getParameter("nome-cadastro");
            String username = request.getParameter("username-cadastro");
            String senha = request.getParameter("senha-cadastro");
            String tipo = request.getParameter("tipo");
            String id = request.getParameter("id");
            
            String msgErro = "";
            String msgSucesso = "";
            
            //validacao
            if(Util.isBlankOrNull(nome)){
                msgErro += "Preencha o campo nome!\n";
            }
            if(Util.isBlankOrNull(username)){
                msgErro += "Preencha o campo usuário!\n";
            }
            if(Util.isBlankOrNull(senha)){
                msgErro += "Preencha o campo senha!\n";
            }
            
            if(Util.isBlankOrNull(id)) { //CREATE
                if(!Util.isBlankOrNull(nome) && !Util.isBlankOrNull(username) && !Util.isBlankOrNull(senha)) {
                    usuarioDao.create(new Usuario(nome, username, senha));
                    msgSucesso = "Cadastro criado com sucesso!";
                }
                paginaDestino = "cadastroUsuario.jsp";
            } else { //UPDATE
                if(!Util.isBlankOrNull(nome) && !Util.isBlankOrNull(username) && !Util.isBlankOrNull(tipo)) {
                    usuarioDao.update(new Usuario(Long.valueOf(id), nome, username, senha, tipo));
                    //msgSucesso = "Registro alterado com sucesso!";
                    //response.sendRedirect(contextPath+"/usuarios");
                    populaUsuarios(request, usuarioDao);
                    paginaDestino = "listaUsuario.jsp";
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
            Usuario usuario = usuarioDao.findbyId(Long.valueOf(id));
            if(usuario != null) {
                request.setAttribute("usuario", usuario);
                paginaDestino = "cadastroUsuario.jsp";
            }
            RequestDispatcher rd = request.getRequestDispatcher(paginaDestino);
            rd.forward(request, response);
        } else if("EXCLUIR".equals(action)) {
            String id = request.getParameter("id");
            if(!Util.isBlankOrNull(id)) {
                usuarioDao.remove(Long.valueOf(id));
            }
            response.sendRedirect(contextPath+"/usuarios");
        }
    }
    
    public void populaUsuarios(HttpServletRequest request, UsuarioDAO usuarioDao) {
        HttpSession session = request.getSession();
        List<Usuario> usuarios = usuarioDao.findAll();
        if(!usuarios.isEmpty()) {
            session.setAttribute("usuarios", usuarios);
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
