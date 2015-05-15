/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.modelo;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Contato {
    
    private String nome;
    private String sobrenome;
    private String categoria;
    private String apelido;
    private String tipoContato;
    private List<Email> emails;
    
    public Contato(){
        
    }
    
    public Contato(String nome, String sobrenome, String categoria, String apelido, String tipoContato, List<Email> emails){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.categoria = categoria;
        this.apelido = apelido;
        this.tipoContato = tipoContato;
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", categoria=" + categoria + ", apelido=" + apelido + ", tipoContato=" + tipoContato + ", emails=" + emails + '}';
    }
    
    

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * @return the apelido
     */
    public String getApelido() {
        return apelido;
    }

    /**
     * @param apelido the apelido to set
     */
    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    /**
     * @return the tipoContatoPadrao
     */
    public String getTipoContatoPadrao() {
        return tipoContato;
    }

    /**
     * @param tipoContatoPadrao the tipoContatoPadrao to set
     */
    public void setTipoContatoPadrao(String tipoContatoPadrao) {
        this.tipoContato = tipoContatoPadrao;
    }

    /**
     * @return the emails
     */
    public List<Email> getEmails() {
        return emails;
    }

    /**
     * @param emails the emails to set
     */
    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }


    
    
    
}
