/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class TestarAtualizacao {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "update Contatos set nome = ?, sobrenome = ? where id = ?";
        PreparedStatement prepareStatement = connection.prepareStatement(sql);
        prepareStatement.setString(1, "Lucas");
        prepareStatement.setString(2, "Nascimento");
        prepareStatement.setInt(3, 7);
        
        boolean retornouLista = prepareStatement.execute();
        int linhasAtualizadas = prepareStatement.getUpdateCount();
        System.out.println(linhasAtualizadas + " linhas atualizadas");
        connection.close();
        prepareStatement.close();
    }
    
}
