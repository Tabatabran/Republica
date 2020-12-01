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
public class HistoricoRepublica {
    protected String nomeRepublica;
    protected LocalDate dataIngresso;
    protected LocalDate dataSaida;
    protected double rateio;
    protected String nomerepResentante;
    protected String telefoneRepresentante;
    protected double mediaReputacao;
    protected boolean republicaAtual; //se o valor for TRUE a republica é a atual

    public HistoricoRepublica(String nomeRepublica, LocalDate dataIngresso, LocalDate dataSaida, double rateio) {
        this.nomeRepublica = nomeRepublica;
        this.dataIngresso = dataIngresso;
        this.dataSaida = dataSaida;
        this.rateio = rateio;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setRepublicaAtual(boolean republicaAtual) {
        this.republicaAtual = republicaAtual;
    }

    public String getNomeRepublica() {
        return nomeRepublica;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public String getNomerepResentante() {
        return nomerepResentante;
    }

    public String getTelefoneRepresentante() {
        return telefoneRepresentante;
    }

    public double getMediaReputacao() {
        return mediaReputacao;
    }

    public boolean isRepublicaAtual() {
        return republicaAtual;
    }
    
}
