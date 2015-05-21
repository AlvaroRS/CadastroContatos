/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class TestaInsercao {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        String txtNome = "Eduardo') drop database;";
        String txtSobrenome = "Nascimento";      
        
        String sql = "insert into Contatos(nome, sobrenome) values ( ? , ? )";
        PreparedStatement statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        statement.setString(1, txtNome);
        statement.setString(2, txtSobrenome);
        
        boolean retornoehlista = statement.execute();
        
        ResultSet rs = statement.getGeneratedKeys();
        
        while (rs.next()){
            int novoId = rs.getInt("id");
            System.out.println(novoId);
        }
        
        
        System.out.println(retornoehlista);
        
        statement.close();
        connection.close();
        
    }
    
}
