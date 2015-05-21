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
public class TestarListagem {

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();

        Statement statement = connection.createStatement();

        boolean retornoEhLista = statement.execute("select * from Contatos");

        System.out.println(retornoEhLista);

        ResultSet rs = statement.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String sobrenome = rs.getString("sobrenome");

            System.out.println(id);
            System.out.println(nome);
            System.out.println(sobrenome);

        }

        rs.close();
        connection.close();
    }

}
