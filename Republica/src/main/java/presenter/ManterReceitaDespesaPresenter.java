package presenter;

import java.awt.event.ActionEvent;
import view.ManterReceitasDespesasView;

public class ManterReceitaDespesaPresenter {
    private ManterReceitasDespesasView view;

    public ManterReceitaDespesaPresenter() {
        this.view = new ManterReceitasDespesasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        buscarReceitaDespesa();
        cadastrarReceitaDespesa();
        editarReceitaDespesa();
        realizarEstorno();
        verInformacoes();
        this.view.setVisible(true);
    }
    
    public void buscarReceitaDespesa() {
        this.view.getJbBuscar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void cadastrarReceitaDespesa(){        
        this.view.getJbCadastrarReceitaDespesa().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void editarReceitaDespesa(){        
        this.view.getJbEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void realizarEstorno(){        
        this.view.getJbRealizarEstorno().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void verInformacoes(){        
        this.view.getJbVerInformacoes().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
