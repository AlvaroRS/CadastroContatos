/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.reges.contatos.modelo;

/**
 *
 * @author lucas
 */
public class Email {
    
    private String enderecoEmail;
    private boolean principal;
    
    public Email (){
    }
    
    public Email(String enderecoEmail, boolean principal){
        this.enderecoEmail = enderecoEmail;
        this.principal = principal;
    }
    
    public String toString(){
        String ehPrincipal  = (principal==true) ? " (principal)" : "" ;
        return enderecoEmail + ehPrincipal  ;
    }
    
    public boolean equals(Email other){
        return this.enderecoEmail.equals(other.getEnderecoEmail());
    }    

    /**
     * @return the enderecoEmail
     */
    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    /**
     * @param enderecoEmail the enderecoEmail to set
     */
    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    /**
     * @return the principal
     */
    public boolean isPrincipal() {
        return principal;
    }

    /**
     * @param principal the principal to set
     */
    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }
    
    
    
}
