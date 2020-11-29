/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.awt.Color;
import java.awt.event.ActionEvent;
import view.CadastroView;

/**
 *
 * @author Thiago
 */
public class CadastroPresenter {
    private CadastroView view;
    public CadastroPresenter() {
        this.view=new CadastroView();
        cadastrar();
        cancelar();
        this.view.setVisible(true);
    }
    public void cadastrar(){
        this.view.getjButtonCadastrar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IDAOUsuario dao = new UsuarioSQLite();
                if(view.getjTextFieldSenha().getText().equals(view.getjTextFieldConfirmarSenha().getText())){
                    dao.addUsuario(view.getjTextFieldNomeUsuario().getText(), view.getjTextFieldSenha().getText());
                    view.setVisible(false);
                }else{
                    view.getjLabelErro().setForeground(Color.red);
                    view.getjLabelErro().setText("Confirme Sua Senha");
                }
                
            }
        });
    }
    public void cancelar(){
        this.view.getjButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancelado");
                view.setVisible(false);
            }
        });
    }
}
