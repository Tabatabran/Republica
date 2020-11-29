/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import java.util.ArrayList;

/**
 *
 * @author tabat
 */
class tabataMorador {
    protected int codigo;
    protected String nome;
    protected String apelido;
    protected String telefone;
    protected String CPF;
    protected String linkRedesSociais;
    protected String telefoneResponsaveis;
    protected ArrayList<HistoricoRepublica> historico;

    public tabataMorador(String nome, String apelido, String telefone, String CPF, String linkRedesSociais, String telefoneResponsaveis) {
        this.nome = nome;
        this.apelido = apelido;
        this.telefone = telefone;
        this.CPF = CPF;
        this.linkRedesSociais = linkRedesSociais;
        this.historico = new ArrayList<>();
        this.telefoneResponsaveis = telefoneResponsaveis;
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getApelido() {
        return apelido;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public String getLinkRedesSociais() {
        return linkRedesSociais;
    }

    public String getTelefoneResponsaveis() {
        return telefoneResponsaveis;
    }

    public ArrayList<HistoricoRepublica> getHistorico() {
        return historico;
    }

    public void addHistorico(HistoricoRepublica historicoRepublica) {
        this.historico.add(historicoRepublica);
    }
    
    
}
