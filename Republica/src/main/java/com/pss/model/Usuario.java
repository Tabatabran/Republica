/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

/**
 *
 * @author tabat
 */

public class Usuario {
    protected String login;
    protected String senha;
    //codigo thiago
    private String nome;
    private String apelido;
    private String telefone1;
    private String CPF;
    private String linkRedeSocial;
    private String telefone2;
    private String telefone3;
    
    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public String getCPF() {
        return CPF;
    }

    public String getLinkRedeSocial() {
        return linkRedeSocial;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }
    //codigo thiago
    public Usuario(String login, String senha) {
        
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public void setLinkRedeSocial(String linkRedeSocial) {
        this.linkRedeSocial = linkRedeSocial;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
    }
    
    
}
