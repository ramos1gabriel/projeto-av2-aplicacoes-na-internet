/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.dao;

import com.av2.gabriel.sousa.model.Produto;
import com.av2.gabriel.sousa.sql.Conexao;
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
public class ProdutoDAO implements DAO<Produto> {

    @Override
    public Produto findbyId(Long id) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = conn.prepareStatement("SELECT * FROM PRODUTO WHERE ID = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getDouble("PRECO"),
                        rs.getString("DESCRICAO"),
                        rs.getString("URL_IMAGEM"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return null;
    }

    @Override
    public void create(Produto produto) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO PRODUTO (NOME, PRECO, DESCRICAO, URL_IMAGEM) VALUES (?, ?, ?, ?)");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.setString(4, produto.getUrl());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }
    
    @Override
    public Produto update(Produto produto) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE PRODUTO SET NOME = ?, PRECO = ?, DESCRICAO = ?, URL_IMAGEM = ? WHERE ID = ?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, produto.getDescricao());
            stmt.setString(4, produto.getUrl());
            stmt.setLong(5, produto.getId());
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("SELECT * FROM PRODUTO WHERE ID = ?");
            stmt.setLong(1, produto.getId());
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Produto(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getDouble("PRECO"),
                        rs.getString("DESCRICAO"),
                        rs.getString("URL_IMAGEM"));
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
            stmt = conn.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }

    @Override
    public List<Produto> findAll() {
        List<Produto> lista = new ArrayList<>();
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM PRODUTO");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                lista.add(new Produto(
                        rs.getLong("ID"),
                        rs.getString("NOME"),
                        rs.getDouble("PRECO"),
                        rs.getString("DESCRICAO"),
                        rs.getString("URL_IMAGEM")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return lista;
    }
}
