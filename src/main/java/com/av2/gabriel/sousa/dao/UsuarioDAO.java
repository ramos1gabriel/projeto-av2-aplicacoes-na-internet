/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.dao;

import com.av2.gabriel.sousa.model.Usuario;
import com.av2.gabriel.sousa.sql.Conexao;
import com.av2.gabriel.sousa.util.PasswordEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO implements DAO<Usuario> {

    public Usuario login(String username, String senha) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = conn.prepareStatement("SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?");
            stmt.setString(1, username);
            stmt.setString(2, PasswordEncoder.encode(senha));
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("USERNAME"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return null;
    }

    @Override
    public Usuario findbyId(Long id) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = conn.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("USERNAME"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return null;
    }

    @Override
    public void create(Usuario usuario) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO USUARIO (NOME, USERNAME, SENHA) VALUES (?, ?, ?)");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, PasswordEncoder.encode(usuario.getSenha()));
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }
    
    @Override
    public Usuario update(Usuario usuario) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE USUARIO SET NOME = ?, USERNAME = ?, SENHA = ?, TIPO = ? WHERE ID = ?");
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getUsername());
            stmt.setString(3, PasswordEncoder.encode(usuario.getSenha()));
            stmt.setString(4, usuario.getTipo());
            stmt.setLong(5, usuario.getId());
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("SELECT * FROM USUARIO WHERE ID = ?");
            stmt.setLong(1, usuario.getId());
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Usuario(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("USERNAME"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return null;
    }

    @Override
    public void remove(Long id) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("DELETE FROM USUARIO WHERE ID = ?");
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }

    @Override
    public List<Usuario> findAll() {
        List<Usuario> lista = new ArrayList<>();
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM USUARIO");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getString("USERNAME"),
                        rs.getString("SENHA"),
                        rs.getString("TIPO")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return lista;
    }
}
