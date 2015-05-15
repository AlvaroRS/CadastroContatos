/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class TestaDeletar {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        Statement statement = connection.createStatement();
        boolean retornouListagem = statement.execute("delete from Contatos where id >= 8");
        System.out.println(retornouListagem);
        
        int linhasAtualizadas = statement.getUpdateCount();
        System.out.println(linhasAtualizadas);
        
        statement.close();
        connection.close();
    }
    
}
