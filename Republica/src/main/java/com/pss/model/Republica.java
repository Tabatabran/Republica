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
public class Republica {
    protected int codigo;
    protected String nome;
    protected LocalDate dataFundacao;
    protected String endereco;
    protected String CEP;
    protected String bairro;
    protected String pondeDeReferencia;
    protected String localizacaoGeografica;
    protected String codigoDeEtica;
    protected String vantagens;
    protected double despesasMediasPorMorador;
    protected int totalDeVagas;
    protected int vagasOcupadas;
    protected int vagasDisponiveis;

    public Republica(String nome, LocalDate dataFundacao, String endereco, String CEP, String bairro, String vantagens, double despesasMediasPorMorador, int totalDeVagas, int vagasOcupadas, int vagasDisponiveis, String referencia) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.endereco = endereco;
        this.CEP = CEP;
        this.bairro = bairro;
        this.vantagens = vantagens;
        this.despesasMediasPorMorador = despesasMediasPorMorador;
        this.totalDeVagas = totalDeVagas;
        this.vagasOcupadas = vagasOcupadas;
        this.vagasDisponiveis = vagasDisponiveis;
        this.pondeDeReferencia = referencia;
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

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCEP() {
        return CEP;
    }

    public String getBairro() {
        return bairro;
    }

    public String getPondeDeReferencia() {
        return pondeDeReferencia;
    }

    public String getLocalizacaoGeografica() {
        return localizacaoGeografica;
    }

    public String getCodigoDeEtica() {
        return codigoDeEtica;
    }

    public String getVantagens() {
        return vantagens;
    }

    public double getDespesasMediasPorMorador() {
        return despesasMediasPorMorador;
    }

    public int getTotalDeVagas() {
        return totalDeVagas;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public int getVagasDisponiveis() {
        return vagasDisponiveis;
    }

    public void setLocalizacaoGeografica(String localizacaoGeografica) {
        this.localizacaoGeografica = localizacaoGeografica;
    }

    public void setCodigoDeEtica(String codigoDeEtica) {
        this.codigoDeEtica = codigoDeEtica;
    }
}
