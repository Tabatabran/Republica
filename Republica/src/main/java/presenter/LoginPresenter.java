/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import view.LoginView;

/**
 *
 * @author Thiago
 */
public class LoginPresenter {
    private LoginView view;
    
    public LoginPresenter() {
        this.view=new LoginView();
        
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
                if(resultado)
                    new TelaPrincipalPresenter();
                else 
                    System.out.println("nononono");                
            }
        });
        
        
        
    }
    private void novoUsuario(){
        this.view.getjButtonNovoUsuario().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Novo usuario");
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
