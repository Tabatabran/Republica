package presenter;

import java.awt.event.ActionEvent;
import view.ManterReceitasDespesasView;

public class ManterReceitaDespesaPresenter {
    private ManterReceitasDespesasView view;

    public ManterReceitaDespesaPresenter() {
        this.view = new ManterReceitasDespesasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        configuraView();
        this.view.setVisible(true);
    }
    
    public void configuraView() {
        this.view.getJbBuscar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbCadastrarReceitaDespesa().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbRealizarEstorno().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbVerInformacoes().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
