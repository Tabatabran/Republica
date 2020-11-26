/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tabat
 */
public class ReceitaDespesa {
    protected int codigo;
    protected String tipo; //receita ou despesa
    protected String descricao;
    protected LocalDate dataDeVencimento;
    protected double valor;
    protected String periodicidade; // uma vez, semanal ou mensal
    protected double valorParcela; //caso a periodicidade seja semanal ou mensal, podendo ser valor ou porcentagem
    protected ArrayList<MoradorParticipante> moradoresparticipantes;

    public ReceitaDespesa(String tipo, String descricao, LocalDate dataDeVencimento, double valor, String periodicidade, ArrayList<MoradorParticipante> moradoresparticipantes) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataDeVencimento = dataDeVencimento;
        this.valor = valor;
        this.periodicidade = periodicidade;
        this.moradoresparticipantes = new ArrayList<>();
        this.moradoresparticipantes = moradoresparticipantes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public double getValor() {
        return valor;
    }

    public String getPeriodicidade() {
        return periodicidade;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public ArrayList<MoradorParticipante> getMoradoresparticipantes() {
        return moradoresparticipantes;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }
    
    
    
    
}
