/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.dao;

import com.av2.gabriel.sousa.model.Compra;
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
public class CompraDAO implements DAO<Compra> {

    public List<Compra> findAllByUsuarioId(Long id) {
        List<Compra> lista = new ArrayList<>();
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            String sql = "SELECT C.ID, C.DATACOMPRA, C.QTD, C.VALORCOMPRA, "
                    + "P.NOME AS 'NOMEPRODUTO', "
                    + "U.NOME AS 'NOMEUSUARIO' "
                    + "FROM COMPRA C, PRODUTO P, USUARIO U "
                    + "WHERE C.ID_USUARIO = U.ID "
                    + "AND C.ID_PRODUTO = P.ID "
                    + "AND C.ID_USUARIO = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("ID"));
                compra.setDataCompra(rs.getDate("DATACOMPRA"));
                compra.setQuantidade(rs.getLong("QTD"));
                compra.setValorCompra(rs.getDouble("VALORCOMPRA"));
                compra.setNomeUsuario(rs.getString("NOMEUSUARIO"));
                compra.setNomeProduto(rs.getString("NOMEPRODUTO"));
                lista.add(compra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return lista;
    }
    
    @Override
    public Compra findbyId(Long id) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            stmt = conn.prepareStatement("SELECT * FROM COMPRA WHERE ID = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if (rs.next()) {
                return new Compra(
                        rs.getLong("ID"),
                        rs.getLong("ID_USUARIO"),
                        rs.getLong("ID_PRODUTO"),
                        rs.getDate("DATACOMPRA"),
                        rs.getLong("QTD"),
                        rs.getDouble("VALORCOMPRA"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return null;
    }

    @Override
    public void create(Compra compra) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement("INSERT INTO COMPRA (ID_USUARIO, ID_PRODUTO, DATACOMPRA, QTD, VALORCOMPRA) VALUES (?, ?, ?, ?, ?)");
            stmt.setLong(1, compra.getIdUsuario());
            stmt.setLong(2, compra.getIdProduto());
            stmt.setDate(3, compra.getDataCompra());
            stmt.setLong(4, compra.getQuantidade());
            stmt.setDouble(5, compra.getValorCompra());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }
    
    @Override
    public Compra update(Compra compra) {
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement("UPDATE COMPRA SET ID_USUARIO = ?, ID_PRODUTO = ?, DATACOMPRA = ?, QTD = ?, VALORCOMPRA = ? WHERE ID = ?");
            stmt.setLong(1, compra.getIdUsuario());
            stmt.setLong(2, compra.getIdProduto());
            stmt.setDate(3, compra.getDataCompra());
            stmt.setLong(4, compra.getQuantidade());
            stmt.setDouble(5, compra.getValorCompra());
            stmt.setLong(6, compra.getId());
            stmt.executeUpdate();
            
            stmt = conn.prepareStatement("SELECT * FROM COMPRA WHERE ID = ?");
            stmt.setLong(1, compra.getId());
            rs = stmt.executeQuery();
            while(rs.next()){
                return new Compra(
                        rs.getLong("ID"),
                        rs.getLong("ID_USUARIO"),
                        rs.getLong("ID_PRODUTO"),
                        rs.getDate("DATACOMPRA"),
                        rs.getLong("QTD"),
                        rs.getDouble("VALORCOMPRA"));
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
            stmt = conn.prepareStatement("DELETE FROM COMPRA WHERE ID = ?");
            stmt.setLong(1, id);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(stmt, conn); //FECHA TUDO
        }
    }

    @Override
    public List<Compra> findAll() {
        List<Compra> lista = new ArrayList<>();
        Connection conn = Conexao.open();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            
            String sql = "SELECT C.ID, C.DATACOMPRA, C.QTD, C.VALORCOMPRA, "
                    + "P.NOME AS 'NOMEPRODUTO', "
                    + "U.NOME AS 'NOMEUSUARIO' "
                    + "FROM COMPRA C, PRODUTO P, USUARIO U "
                    + "WHERE C.ID_USUARIO = U.ID "
                    + "AND C.ID_PRODUTO = P.ID";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Compra compra = new Compra();
                compra.setId(rs.getLong("ID"));
                compra.setDataCompra(rs.getDate("DATACOMPRA"));
                compra.setQuantidade(rs.getLong("QTD"));
                compra.setValorCompra(rs.getDouble("VALORCOMPRA"));
                compra.setNomeUsuario(rs.getString("NOMEUSUARIO"));
                compra.setNomeProduto(rs.getString("NOMEPRODUTO"));
                lista.add(compra);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexao.close(rs, stmt, conn); //FECHA TUDO
        }
        return lista;
    }
}
