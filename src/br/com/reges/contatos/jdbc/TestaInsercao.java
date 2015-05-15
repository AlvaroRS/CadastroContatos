/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
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
        Statement statement = connection.createStatement();
        
        String txtNome = "Eduardo";
        String txtSobrenome = "Nascimento";
        
        boolean retornoehlista = statement.execute("insert into Contatos(nome, sobrenome) values ('"+ txtNome +"', '"+txtSobrenome+"')", Statement.RETURN_GENERATED_KEYS);
        
        ResultSet rs = statement.getGeneratedKeys();
        
        while (rs.next()){
            int novoId = rs.getInt("GENERATED_KEY");
            System.out.println(novoId);
        }
        
        
        System.out.println(retornoehlista);
        
        statement.close();
        connection.close();
        
    }
    
}
