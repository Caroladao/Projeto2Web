/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 * @author carol
 */
public class Usuario {
    
    private String login;
    private String senha;
    private String nome;
    private String email;
    private String endereco;
    private boolean adm;
    
    public Usuario(){
    }
    
    public Usuario(String login,String senha, String nome, String email, String endereco, boolean adm){
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.adm = adm;
    }
    
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getAdm() {
        return adm;
    }
    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
}
