/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import view.ManterPerfilView;

/**
 *
 * @author Thiago
 */
public class ManterPerfilPresenter {
    private ManterPerfilView view;

    public ManterPerfilPresenter() {
        this.view = new ManterPerfilView();
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
}
