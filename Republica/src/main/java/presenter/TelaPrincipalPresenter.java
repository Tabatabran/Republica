
package presenter;

import java.awt.event.ActionEvent;
import presenter.ManterPerfil.ManterPerfilPresenter;
import view.ManterMoradorView;
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
        CriarRupublica();
        manterTarefas();
        manterMoradores();
        registrarConclusaoTarefas();
        view.setVisible(true);
    }
    
    public void manterMoradores(){
        this.view.getjMenuItemManterMoradores().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterMoradorPresenter();
            }
        });
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
    public void manterTarefas(){
        this.view.getjMenuItemManterTarefas().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterTarefasPresenter();
            }
        });
    }
    public void registrarConclusaoTarefas(){
        this.view.getjMenuItemRegistrarConclusao().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistrarConfirmacaoTarefaPresenter();
            }
        });
    }    

}
