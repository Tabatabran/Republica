/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.ReceitaDespesa;

/**
 *
 * @author tabat
 */
public interface IDAOReceitaDespesa {
    public void cadastrarReceitaDespesa(ReceitaDespesa receitaDespesa);
    public void cadastrarListaDeMoradoresParticipantes(ReceitaDespesa receitaDespesa);
}
