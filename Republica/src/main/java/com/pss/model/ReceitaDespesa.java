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
    protected String tipo;
    protected String descricao;
    protected LocalDate dataVencimento;
    protected LocalDate dataCadastro;
    protected double valor;
    protected String periodicidade; 
    protected double valorParcela; 
    protected ArrayList<String> moradoresparticipantes;

    public ReceitaDespesa(String tipo, String descricao, LocalDate dataCadastro, double valor, String periodicidade, ArrayList<String> moradoresparticipantes) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
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

    public LocalDate getDataVencimento() {
        return dataVencimento;
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

    public ArrayList<String> getMoradoresparticipantes() {
        return moradoresparticipantes;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }
    
    
    
    
}
