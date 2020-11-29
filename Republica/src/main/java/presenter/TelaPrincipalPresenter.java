
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
        this.view.setLocationRelativeTo(null);
        marterRupublica();
        manterPerfil();
        view.setVisible(true);
    }
    
    public void marterRupublica(){
        this.view.getjMenuItemManterRepublica().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterRepublicaPresenter();
            }
        });
    }
    public void manterPerfil(){
        this.view.getjMenuItemManterPerfil().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterPerfilPresenter();
            }
        });
    }
        public void CriarRupublica(){
        this.view.getjMenuItemCriarRepublica().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CriarRepublicaPresenter();
            }
        });
    }
    
    

}
