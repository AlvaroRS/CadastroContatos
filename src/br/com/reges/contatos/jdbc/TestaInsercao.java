/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.jdbc;

import br.com.reges.contatos.dao.ContatosDAO;
import br.com.reges.contatos.modelo.Contato;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author lucas
 */
public class TestaInsercao {
    
    
 

    public static void main(String[] args) throws SQLException {
        Connection connection = Database.getConnection();
        
        Contato contato = new Contato();
        contato.setNome("Lucas");
        contato.setSobrenome("Nascimento");
        contato.setCategoria("familia");
        contato.setApelido("Lucas");

        ContatosDAO contatosDao = new ContatosDAO(connection);
        Contato contatoInserido = contatosDao.inserir(contato);
        
        List<Contato> contatosList = contatosDao.listar();
        
        
        System.out.println(contatoInserido);
        System.out.println(contatosList.size());
        
        
        contatosDao.deleta(contatoInserido);
        
        contatosList = contatosDao.listar();
        System.out.println(contatosList.size());
        
        
        connection.close();

    }

}
