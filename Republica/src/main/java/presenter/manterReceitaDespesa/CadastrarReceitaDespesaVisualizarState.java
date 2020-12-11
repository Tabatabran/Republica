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
public class CadastrarReceitaDespesaVisualizarState extends CadastrarReceitaDespesaState{

    public CadastrarReceitaDespesaVisualizarState(CadastrarReceitaDespesaPresenter presenter) {
        super(presenter);
    }

    @Override
    public void configuraView(ReceitaDespesa receitadespesa) {
        presenter.configuraViewVizualizar(receitadespesa);
    }
    
}
