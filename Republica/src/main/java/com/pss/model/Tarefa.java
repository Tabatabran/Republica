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
public class Tarefa {
    protected int codigo;
    protected LocalDate dataAgendamento;
    protected ArrayList<tabataMorador> responsaveis;
    protected String descricao;
    protected LocalDate dataTermino;
    protected boolean finalizada; //se true a tarefa é marcada como concluída

    public Tarefa(int codigo, LocalDate dataAgendamento, ArrayList<tabataMorador> responsaveis, String descricao, LocalDate dataTermino) {
        this.codigo = codigo;
        this.dataAgendamento = dataAgendamento;
        this.responsaveis = responsaveis;
        this.descricao = descricao;
        this.dataTermino = dataTermino;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public ArrayList<tabataMorador> getResponsaveis() {
        return responsaveis;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }
    
    
    
}
