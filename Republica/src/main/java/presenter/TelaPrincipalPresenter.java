/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import java.awt.event.ActionEvent;
import view.TelaPrincipalView;

/**
 *
 * @author Thiago
 */
public class TelaPrincipalPresenter {
    private TelaPrincipalView  view;
    
    public TelaPrincipalPresenter() {
        
        this.view=new TelaPrincipalView();
        view.setVisible(true);
        marterRupublica();
        
    }
    
    public void marterRupublica(){
        this.view.getjMenuItemManterRepublica().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterRepublicaPresenter();
            }
        });
    }
    

}
