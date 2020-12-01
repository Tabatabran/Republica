/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter.ManterPerfil;

import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import java.awt.event.ActionEvent;
import view.ManterPerfilView;

/**
 *
 * @author Thiago
 */
public class ManterPerfilPresenter {
    private ManterPerfilState state;
    private ManterPerfilView view;
    
    public ManterPerfilPresenter() {
        
        this.view = new ManterPerfilView();
        excluirConta();
        exibirHistorico();
        editar();
        this.view.setLocationRelativeTo(null);
        this.state= new ManterPerfilInicialState(this);
        this.view.setVisible(true);
        
    }
    public void changeState(ManterPerfilState state){
        this.state=state;
    }
    public void excluirConta(){
     this.view.getjButtonExcluir().addActionListener(new java.awt.event.ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             state.excluirConta();
         }
     });
    }
    public void exibirHistorico(){
        this.view.getjButtonHistorico().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.exibirHistorico();
            }
        });
    }
    public void editar(){
        this.view.getjButtonEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state.editar();
            }
        });
    }
    public void setViewEditarState(){
        this.view.getjButtonExcluir().setEnabled(false);
        this.view.getjButtonExcluir().setVisible(false);
        
        this.view.getjButtonHistorico().setEnabled(false);
        this.view.getjButtonHistorico().setVisible(false);
        
        this.view.getjButtonEditar().setText("Confirmar");
        
        this.view.getjTextFieldApelido().setEditable(true);
        this.view.getjTextFieldNome().setEditable(true);
        this.view.getjTextFieldRedeSocial().setEditable(true);
        this.view.getjTextFieldTelefone1().setEditable(true);
        this.view.getjTextFieldTelefone2().setEditable(true);
        this.view.getjTextFieldTelefone3().setEditable(true);
        
        this.view.getjRadioButtonPublico().setEnabled(true);
        this.view.getjRadioButtonPrivado().setEnabled(true);
        
    }
     public void setViewInicialState(){
        this.view.getjButtonExcluir().setEnabled(true);
        this.view.getjButtonExcluir().setVisible(true);
        
        this.view.getjButtonHistorico().setEnabled(true);
        this.view.getjButtonHistorico().setVisible(true);
        
        this.view.getjButtonEditar().setText("Editar");
        
        UsuarioLogado usuario = UsuarioLogado.getInstancia();
        this.view.getjTextFieldApelido().setText(usuario.getApelido());
        this.view.getjTextFieldNome().setText(usuario.getNome());
        this.view.getjTextFieldRedeSocial().setText(usuario.getLinkRedeSocial());
        this.view.getjTextFieldTelefone1().setText(usuario.getTelefone1());
        this.view.getjTextFieldTelefone2().setText(usuario.getTelefone2());
        this.view.getjTextFieldTelefone3().setText(usuario.getTelefone3());
        
        this.view.getjTextFieldApelido().setEditable(false);
        this.view.getjTextFieldNome().setEditable(false);
        this.view.getjTextFieldRedeSocial().setEditable(false);
        this.view.getjTextFieldTelefone1().setEditable(false);
        this.view.getjTextFieldTelefone2().setEditable(false);
        this.view.getjTextFieldTelefone3().setEditable(false);
        
        this.view.getjRadioButtonPublico().setEnabled(false);
        this.view.getjRadioButtonPrivado().setEnabled(false);
        
    }
}
