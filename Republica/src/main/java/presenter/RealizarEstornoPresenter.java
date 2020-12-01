package presenter;

import java.awt.event.ActionEvent;
import view.RealizarEstornoView;

public class RealizarEstornoPresenter {
    private RealizarEstornoView view;

    public RealizarEstornoPresenter() {
        this.view = new RealizarEstornoView();
        this.view.setLocationRelativeTo(null);
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        confirmarEstorno();
        this.view.setVisible(true);
    }
    
    public void configuraBotaoDireita() {
        this.view.getJbBotaoDireita().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void configuraBotaoEsquerda(){        
        this.view.getJbBotaoEsquerda().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void confirmarEstorno(){        
        this.view.getJbConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}
