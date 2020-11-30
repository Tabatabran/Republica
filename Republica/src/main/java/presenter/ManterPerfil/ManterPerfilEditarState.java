/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.ManterPerfil;

/**
 *
 * @author Thiago
 */
public class ManterPerfilEditarState extends ManterPerfilState{
    
    public ManterPerfilEditarState(ManterPerfilPresenter presenter) {
        super(presenter);
        presenter.setViewEditarState();
    }
    @Override
    public void excluirConta(){
        
    }
    @Override
    public void exibirHistorico(){
        
    }
    @Override
    public void editar(){
       this.presenter.changeState(new ManterPerfilInicialState(presenter));
    }
}
