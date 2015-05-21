/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class TestarDelecao {
    
    public static void main(String[] args) throws SQLException {
        
        Connection connection = Database.getConnection();
        
        String sql = "delete from Contatos where id >= ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, 6);
        
        boolean retornoEhLista = stm.execute();
        int numeroDeDeletados = stm.getUpdateCount();
        
        System.out.println(numeroDeDeletados + " registros exluídos");
        
        
        stm.close();
        connection.close();
        
        
    }
    
}
