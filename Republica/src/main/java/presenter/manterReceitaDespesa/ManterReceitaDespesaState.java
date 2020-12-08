/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.manterReceitaDespesa;

/**
 *
 * @author tabat
 */
public abstract class ManterReceitaDespesaState {
    protected ManterReceitaDespesaPresenter presenter;
    
    public ManterReceitaDespesaState(ManterReceitaDespesaPresenter presenter){
        this.presenter=presenter;
    }
    
    public abstract void excluirConta();
    public abstract void exibirHistorico();
    public abstract void editar();
}
