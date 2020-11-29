package presenter;

import java.awt.event.ActionEvent;
import view.CadastrarReceitaDespesaView;

public class CadastrarReceitaDespesaPresenter {
    private CadastrarReceitaDespesaView view;

    public CadastrarReceitaDespesaPresenter() {
        this.view = new CadastrarReceitaDespesaView();
        configuraView();
        this.view.setVisible(true);
    }
    
    public void configuraView() {
        this.view.getJbBotaoDireita().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbBotaoEsquerda().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
