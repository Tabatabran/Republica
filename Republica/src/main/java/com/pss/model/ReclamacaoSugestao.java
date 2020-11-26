/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import java.time.LocalDate;

/**
 *
 * @author tabat
 */
public class ReclamacaoSugestao {
    protected int codigo;
    protected LocalDate dataCriacao;
    protected boolean anonima;//se o valor for true não registra o morador reclamante
    protected Morador moradorReclamante; //quem fez, não terá se for anônima
    protected String descricao;
    protected LocalDate dataSolucao;
    protected int idade; //dias que levou pra ser solucionada
    protected boolean excluida; //marcar como true caso ela seja excluida pelo representante

    public ReclamacaoSugestao(LocalDate dataCriacao, boolean anonima, String descricao) {
        this.dataCriacao = dataCriacao;
        this.anonima = anonima;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public boolean isAnonima() {
        return anonima;
    }

    public Morador getMoradorReclamante() {
        return moradorReclamante;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataSolucao() {
        return dataSolucao;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isExcluida() {
        return excluida;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setMoradorReclamante(Morador moradorReclamante) {
        this.moradorReclamante = moradorReclamante;
    }

    public void setDataSolucao(LocalDate dataSolucao) {
        this.dataSolucao = dataSolucao;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setExcluida(boolean excluida) {
        this.excluida = excluida;
    }
    
    
}
