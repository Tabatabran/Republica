/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author tabat
 */
public class Tarefa {
    protected int codigo;
    protected LocalDate dataAgendamento;
    protected ArrayList<Usuario> responsaveis;
    protected String descricao;
    protected LocalDate dataTermino;
    protected boolean finalizada; //se true a tarefa é marcada como concluída

    public Tarefa( LocalDate dataAgendamento, ArrayList<Usuario> responsaveis, String descricao, LocalDate dataTermino) {
        //this.codigo = codigo;
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

    public ArrayList<Usuario> getResponsaveis() {
        return responsaveis;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public void setResponsaveis(ArrayList<Usuario> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }
    public void addResponsavel(Usuario usuario){
        this.responsaveis.add(usuario);
    }
    
    // transforma o LocalDate em String
    public String dataTerminoFormatada(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dataFormatada = dataTermino.format(formatoData);
        
        return dataFormatada;
    }
    
    public String dataAgendamentoFormatada(){
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String dataFormatada = dataAgendamento.format(formatoData);
        
        return dataFormatada;
    }    
}
