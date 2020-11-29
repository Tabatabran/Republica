/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

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
        this.view.setVisible(true);
    }
    public void cadastrar(){
        this.view.getjButtonCadastrar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    
}
