package presenter;

import java.awt.event.ActionEvent;
import view.ManterTarefasView;

public class ManterTarefasPresenter {
    private ManterTarefasView view;
    
    public ManterTarefasPresenter() {
        this.view  = new ManterTarefasView();
        this.view.setLocationRelativeTo(null);
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        buscarTarefa();
        cadastrarTarefa();
        editarTarefa();
        excluirTarefa();
        this.view.setVisible(true);
    }
    
    public void buscarTarefa() {
        this.view.getJbBuscar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void cadastrarTarefa(){        
        this.view.getJbCadastrarTarefa().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarTarefasPresenter();
                view.setVisible(false);
            }
        });
    }
    public void editarTarefa(){
        this.view.getJbEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void excluirTarefa(){
        this.view.getJbExcluir().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}