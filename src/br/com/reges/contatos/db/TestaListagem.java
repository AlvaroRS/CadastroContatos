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
public class TestaListagem {
    
    public static void main(String[] args) throws SQLException{
        Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Agenda","root", "root");
        System.out.println("Conectiou no Mysql");
        
        Statement statement = connection.createStatement();
        boolean retornouLista = statement.execute("Select * from Contatos");
        
        ResultSet rs = statement.getResultSet();
        
        while(rs.next()){
            String id = rs.getString("id");
            String nome = rs.getString("nome");
            String sobrenome = rs.getString("sobrenome");
            String categoria = rs.getString("categoria");
            String apelido = rs.getString("apelido");
            String tipoContato = rs.getString("tipo_contato");

            System.out.println(id);
            System.out.println(nome);
            System.out.println(sobrenome);
            System.out.println(categoria);
            System.out.println(apelido);
            System.out.println(tipoContato);
        }

        rs.close();
        statement.close();
        connection.close();
    }
}
