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
public class TestaAlteracao {
    
    public static void main(String[] args) throws SQLException {
        //Pega conexão com o Banco de Dados
        Connection c = Database.getConnection(); 
        //Preparar o Statement
        String sql = "update Contatos set nome = ? where id > ?";
        PreparedStatement stm = c.prepareStatement(sql);
        stm.setString(1, "Lucas Eduardo");
        stm.setInt(2, 1);
        //Executar o Statement
        stm.execute();
        //exibe o numero de linhas alteradas
        int numeroDeLinhas = stm.getUpdateCount();
        
        System.out.println(numeroDeLinhas);
        
        stm.close();
        c.close();
        
    }
    
}
