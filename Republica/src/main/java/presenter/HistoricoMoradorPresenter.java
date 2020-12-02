/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import view.HistoricoMoradorView;

/**
 *
 * @author Thiago
 */
public class HistoricoMoradorPresenter {
    HistoricoMoradorView view;

    public HistoricoMoradorPresenter() {
        this.view= new HistoricoMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
         this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
}
