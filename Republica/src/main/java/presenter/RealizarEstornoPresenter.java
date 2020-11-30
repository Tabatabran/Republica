package presenter;

import java.awt.event.ActionEvent;
import view.RealizarEstornoView;

public class RealizarEstornoPresenter {
    private RealizarEstornoView view;

    public RealizarEstornoPresenter() {
        this.view = new RealizarEstornoView();
        this.view.setLocationRelativeTo(null);
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
