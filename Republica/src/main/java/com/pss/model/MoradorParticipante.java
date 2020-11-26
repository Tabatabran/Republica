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
class MoradorParticipante {
    protected int codigo;
    protected String nomeMorador;
    protected String participa; //sim ou não
    protected double valorParticipacao; //em % ou R$

    public MoradorParticipante(String nomeMorador, String participa, double valorParticipacao) {
        this.nomeMorador = nomeMorador;
        this.participa = participa;
        this.valorParticipacao = valorParticipacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNomeMorador() {
        return nomeMorador;
    }

    public String getParticipa() {
        return participa;
    }

    public double getValorParticipacao() {
        return valorParticipacao;
    }
    
    
}
