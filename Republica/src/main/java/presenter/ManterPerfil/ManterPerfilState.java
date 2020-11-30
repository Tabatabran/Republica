/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.ManterPerfil;

import java.awt.event.ActionEvent;

/**
 *
 * @author Thiago
 */
public abstract class ManterPerfilState {
    protected ManterPerfilPresenter presenter;
    public ManterPerfilState(ManterPerfilPresenter presenter){
        this.presenter=presenter;
    }
    public abstract void excluirConta();
    public abstract void exibirHistorico();
    public abstract void editar();
}
