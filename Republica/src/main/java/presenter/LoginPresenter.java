/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.Usuario;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.awt.Color;
import java.awt.event.ActionEvent;
import view.LoginView;

/**
 *
 * @author Thiago
 */
public class LoginPresenter {
    private LoginView view;
    //private Usuario logado;

  
    public LoginPresenter() {
        this.view=new LoginView();
        this.view.setLocationRelativeTo(null);
        acessar();
        novoUsuario();
        cancelar();
        view.setVisible(true);
        
    }
    private void acessar(){
        this.view.getjButtonAcessar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Loguei");
                IDAOUsuario dao = new UsuarioSQLite();
                boolean resultado= dao.consultarLogin(view.getjTextFieldUsuario().getText(), view.getjTextFieldSenha().getText());
                if(resultado){
                    //UsuarioLogado.getInstancia(nome, apelido, login, redeSocial, telefone1, telefone2, telefone3);
                    new TelaPrincipalPresenter();
                    view.setVisible(false);
                }
                else{ 
                    view.getjLabelErro().setForeground(Color.red);
                    view.getjLabelErro().setText("Usuário ou Senha Incorretos");               
                }
                }
        });
        
        
        
    }
    private void novoUsuario(){
        this.view.getjButtonNovoUsuario().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroPresenter cadastro = new CadastroPresenter();
                
                
            }
        });
    }
    private void cancelar(){
        this.view.getjButtonCancelar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("cancelado");
                view.setVisible(false);
            }
        });
        
       
    }
}
