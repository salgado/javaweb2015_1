/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.lasalle.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author salgado
 */
public class ConnectionFactory {
    private String connectionString = "jdbc:derby://localhost:1527/jw_db";
    private String user="java";
    private String pass= "java";
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
          connectionString, user, pass);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
