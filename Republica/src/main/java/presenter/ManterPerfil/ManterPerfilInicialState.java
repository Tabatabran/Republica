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
public class ManterPerfilInicialState extends ManterPerfilState{
    
    public ManterPerfilInicialState(ManterPerfilPresenter presenter) {
        super(presenter);
        this.presenter.setViewInicialState();
    }
    @Override
    public void excluirConta(){
        
    }
    @Override
    public  void exibirHistorico(){
        
    }
    @Override
    public  void editar(){
        this.presenter.changeState(new ManterPerfilEditarState(presenter));
    }
    
}
