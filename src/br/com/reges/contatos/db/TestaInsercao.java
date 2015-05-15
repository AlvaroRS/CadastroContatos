/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.db;

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
        
        boolean retornouListagem = statement.execute("insert into Contatos(nome, sobrenome, categoria) values ('Inserido', 'pelo Java', 'trabalho')",Statement.RETURN_GENERATED_KEYS);
        System.out.println(retornouListagem);
        
        ResultSet resultSet = statement.getGeneratedKeys();
        while (resultSet.next()){
            Integer idGerado = resultSet.getInt("GENERATED_KEY");
            System.out.println(idGerado + " chave gerada");
        }
        
        resultSet.close();
        statement.close();
        connection.close();
    }

}
