/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.manterReceitaDespesa;

import com.pss.model.ReceitaDespesa;

/**
 *
 * @author tabat
 */
public abstract class CadastrarReceitaDespesaState {
    protected CadastrarReceitaDespesaPresenter presenter;
    
    public CadastrarReceitaDespesaState(CadastrarReceitaDespesaPresenter presenter){
        this.presenter=presenter;
    }
    
    public abstract void configuraView(ReceitaDespesa receitadespesa);
}
