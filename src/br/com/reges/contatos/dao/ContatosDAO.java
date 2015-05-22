package br.com.reges.contatos.dao;

import br.com.reges.contatos.modelo.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas
 */
public class ContatosDAO {

    private Connection conn;

    public ContatosDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Contato> listar() throws SQLException {
        List<Contato> contatosList = new ArrayList<Contato>();
        Statement statement = conn.createStatement();

        boolean retornoEhLista = statement.execute("select * from Contatos");

        System.out.println(retornoEhLista);

        ResultSet rs = statement.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String sobrenome = rs.getString("sobrenome");

            Contato contato = new Contato();
            contato.setId(id);
            contato.setNome(nome);
            contato.setSobrenome(sobrenome);
            contatosList.add(contato);

        }

        rs.close();
        return contatosList;

    }

    public Contato inserir(Contato contato) throws SQLException {

        String sql = "insert into Contatos(nome, sobrenome, apelido, tipo_contato, categoria) values ( ? , ? , ? , ? , ? )";
        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        statement.setString(1, contato.getNome());
        statement.setString(2, contato.getSobrenome());
        statement.setString(3, contato.getApelido());
        statement.setString(4, contato.getTipoContatoPadrao());
        statement.setString(5, contato.getCategoria());

        statement.execute();

        ResultSet rs = statement.getGeneratedKeys();

        while (rs.next()) {
            int novoId = rs.getInt("id");
            contato.setId(novoId);
        }
        statement.close();
        return contato;
    }

    public Contato atualizar(Contato contato) throws SQLException {
        String sql = "update Contatos set nome = ?, sobrenome = ?, apelido = ?, tipo_contato = ? where id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);

        stm.setString(1, contato.getNome());
        stm.setString(2, contato.getSobrenome());
        stm.setString(3, contato.getApelido());
        stm.setString(4, contato.getTipoContato());

        stm.setInt(5, contato.getId());

        stm.execute();
        int numeroDeLinhas = stm.getUpdateCount();

        stm.close();

        return contato;
    }

    public boolean deleta(Contato contato) throws SQLException {
        String sql = "delete from Contatos where id = ?";
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setInt(1, contato.getId());

        boolean retornoEhLista = stm.execute();
        int numeroDeDeletados = stm.getUpdateCount();
        stm.close();

        return numeroDeDeletados == 1;
    }

}
