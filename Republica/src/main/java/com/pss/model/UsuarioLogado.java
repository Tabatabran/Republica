/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import com.pss.model.Usuario;

/**
 *
 * @author Thiago
 */
public class UsuarioLogado extends Usuario{
    private static UsuarioLogado usuario;
    
    private UsuarioLogado(String login, String senha,String nome, String apelido, String cpf, String redeSocial, String telefone1, String telefone2, String telefone3, String republicaAtual){
        this.setLogin(login);
        this.setSenha(senha);
        this.setNome(nome);
        this.setApelido(apelido);
        this.setCPF(cpf);        
        this.setLinkRedeSocial(redeSocial);
        this.setTelefone1(telefone1);
        this.setTelefone2(telefone2);
        this.setTelefone3(telefone3);
        this.setRepublicaAtual(republicaAtual);
    }
    
    public static UsuarioLogado getInstancia(String login, String senha, String nome, String apelido, String cpf, String redeSocial, String telefone1, String telefone2, String telefone3, String republicaAtual){
        if(usuario==null){
            usuario=new UsuarioLogado(login, senha, nome, apelido, cpf, redeSocial, telefone1, telefone2,  telefone3, republicaAtual);
        }
        return usuario;
    }
    
    public static UsuarioLogado getInstancia(){
        if(!(usuario==null)){
            return usuario;
        }
        System.err.println("WARNING: retornando usuario null");
        return null;
    }
}
