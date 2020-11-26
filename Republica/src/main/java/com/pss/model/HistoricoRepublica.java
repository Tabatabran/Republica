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
class HistoricoRepublica {
    protected int codigo;
    protected String nomeRepublica;
    protected LocalDate dataSaida;
    protected String nomerepResentante;
    protected String telefoneRepresentante;
    protected double mediaReputacao;
    protected boolean republicaAtual; //se o valor for TRUE a republica é a atual

    public HistoricoRepublica(String nomeRepublica, String nomerepResentante, String telefoneRepresentante, double mediaReputacao, boolean republicaAtual) {
        this.nomeRepublica = nomeRepublica;
        this.nomerepResentante = nomerepResentante;
        this.telefoneRepresentante = telefoneRepresentante;
        this.mediaReputacao = mediaReputacao;
        this.republicaAtual = republicaAtual;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
