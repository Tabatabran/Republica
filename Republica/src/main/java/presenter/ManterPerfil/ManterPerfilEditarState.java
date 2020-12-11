/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.ManterPerfil;

import com.pss.model.UsuarioLogado;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import javax.swing.JOptionPane;

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
        if(super.presenter.isValid()){
            

            if( this.presenter.view.getjTextFieldNome().getVerifyInputWhenFocusTarget()){
                 UsuarioLogado.getInstancia().setNome(this.presenter.view.getjTextFieldNome().getText());

            }else{
                this.presenter.view.getjTextFieldNome().invalidate();
            }
            UsuarioLogado.getInstancia().setApelido(this.presenter.view.getjTextFieldApelido().getText());
            UsuarioLogado.getInstancia().setLinkRedeSocial(this.presenter.view.getjTextFieldRedeSocial().getText());
            UsuarioLogado.getInstancia().setTelefone1(this.presenter.view.getjTextFieldTelefone1().getText());
            UsuarioLogado.getInstancia().setTelefone2(this.presenter.view.getjTextFieldTelefone2().getText());
            UsuarioLogado.getInstancia().setTelefone3(this.presenter.view.getjTextFieldTelefone3().getText());
            if(this.presenter.view.getButtonGroup1().getSelection().equals(this.presenter.view.getjRadioButtonPrivado())){
                UsuarioLogado.getInstancia().setPerfil(false);
            }else{
                UsuarioLogado.getInstancia().setPerfil(true);
            }
            IDAOUsuario dao = new UsuarioSQLite();
            dao.alterarPerfilUsuario();
           this.presenter.changeState(new ManterPerfilInicialState(presenter));
        }else{
            JOptionPane.showMessageDialog(null, "dados invalidos! Preencha o numero de telefone");
        }
            
            
    }
}//fim da classe
