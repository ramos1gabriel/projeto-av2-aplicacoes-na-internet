/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av2.gabriel.sousa.sql;

/**
 *
 * @author Gabriel
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Conexao {

    private static final String USUARIO = "root";
    private static final String SENHA = "12345";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/trabalho_av2?useTimezone=true&serverTimezone=UTC";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //ANTIGO=com.mysql.jdbc.Driver

    public static Connection open() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }

    public static void close(PreparedStatement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(Connection conn) {
        close(null, null, conn);
    }
    
    /*TESTE
    public static void main(String[] args) {
       try {
            Connection conn = Conexao.open();
            PreparedStatement stmt2 = conn.prepareStatement("SELECT * FROM USUARIO");
            ResultSet rs = stmt2.executeQuery();
            while (rs.next()) {
                System.out.println("Código:"+rs.getInt("ID"));
            }
            Conexao.close(rs, stmt2, conn);
        } catch(Exception ex) {
            System.out.println("Deu erro:"+ex.getMessage());
        }
    }*/
}
