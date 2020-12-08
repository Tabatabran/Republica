
package presenter;

import java.awt.event.ActionEvent;
import presenter.ManterPerfil.ManterPerfilPresenter;
import presenter.manterReceitaDespesa.ManterReceitaDespesaPresenter;
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
        manterReceitaDespesa();
        aceitarConvite();
        buscarVagas();
        convidarAceitarConviter();
        view.setVisible(true);
    }
    
    public void buscarVagas(){
        this.view.getjMenuItemBuscarVagas().addActionListener((e) -> {
            new BuscarVagasPresenter();
        });
    }
    
    public void convidarAceitarConviter(){
        this.view.getjMenuItemConvidarAceitarConvites().addActionListener((e) -> {
            new ConvidarMoradorPresenter();
        });
    }
    
    public void aceitarConvite(){
        this.view.getjMenuItemAceitarConvite().addActionListener((e) -> {
            new AceitarConvitesPresenter();
        });
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
    
    public void manterReceitaDespesa(){
        this.view.getjMenuItemManterReceitaDespesa().addActionListener(new java.awt.event.ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterReceitaDespesaPresenter();
            }
        });
    } 

}
