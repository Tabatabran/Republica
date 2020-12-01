/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

import java.time.LocalDate;

/**
 *
 * @author vitor
 */
public class RepublicaUsuarioLogado extends Republica{
    private static RepublicaUsuarioLogado republica;

    public static void criarInstancia(String nome, LocalDate dataFundacao, String endereco, String CEP, String bairro, String vantagens, double despesasMediasPorMorador, int totalDeVagas, int vagasOcupadas, int vagasDisponiveis, String referencia){
        republica = new RepublicaUsuarioLogado(nome, dataFundacao, endereco, CEP, bairro, vantagens, despesasMediasPorMorador, totalDeVagas, vagasOcupadas, vagasDisponiveis, referencia);
    }
    
    public static void criarInstancia(Republica novaRepublica){
        republica = new RepublicaUsuarioLogado(novaRepublica.getNome(), novaRepublica.getDataFundacao(), novaRepublica.getEndereco(), novaRepublica.getCEP(), novaRepublica.getBairro(), novaRepublica.getVantagens(), novaRepublica.getDespesasMediasPorMorador(), novaRepublica.getTotalDeVagas(), novaRepublica.getVagasOcupadas(), novaRepublica.getVagasDisponiveis(), novaRepublica.getPondeDeReferencia());
    }
    
    public static RepublicaUsuarioLogado getInstancia(String nome, LocalDate dataFundacao, String endereco, String CEP, String bairro, String vantagens, double despesasMediasPorMorador, int totalDeVagas, int vagasOcupadas, int vagasDisponiveis, String referencia){
        if(republica==null){
            republica=new RepublicaUsuarioLogado(nome, dataFundacao, endereco, CEP, bairro, vantagens, despesasMediasPorMorador, totalDeVagas,  vagasOcupadas, vagasDisponiveis, referencia);
        }
        return republica;
    }
    
    public static RepublicaUsuarioLogado getInstancia(){
        if(!(republica==null)){
            return republica;
        }
        System.err.println("WARNING: retornando RepublicaUsuarioLogado null");
        return null;
    }

    private RepublicaUsuarioLogado(String nome, LocalDate dataFundacao, String endereco, String CEP, String bairro, String vantagens, double despesasMediasPorMorador, int totalDeVagas, int vagasOcupadas, int vagasDisponiveis, String referencia) {
        super(nome, dataFundacao, endereco, CEP, bairro, vantagens, despesasMediasPorMorador, totalDeVagas, vagasOcupadas, vagasDisponiveis, referencia);
    }
}
