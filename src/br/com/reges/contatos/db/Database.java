/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class Database {
    
    static Connection getConnection () throws SQLException{
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Agenda","root", "root");
        return connection;
    }
    
}
