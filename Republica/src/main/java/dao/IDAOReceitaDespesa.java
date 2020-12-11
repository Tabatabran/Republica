/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.ReceitaDespesa;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author tabat
 */
public interface IDAOReceitaDespesa {
    public void cadastrarReceitaDespesa(ReceitaDespesa receitaDespesa);
    public void cadastrarListaDeMoradoresParticipantes(ReceitaDespesa receitaDespesa);
    public ArrayList<ReceitaDespesa> buscarReceitasDespesas(String nomeRepublica);
    public ArrayList<ReceitaDespesa> buscarReceitaDespesaPorPessoa(String nomeUsuario);
    public ArrayList<ReceitaDespesa> buscarReceitaDespesaPorData(LocalDate dataVencimento);
    public ReceitaDespesa buscarReceitaDespesa(int codigo);
}
