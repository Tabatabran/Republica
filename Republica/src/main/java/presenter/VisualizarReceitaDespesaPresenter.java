package presenter;

import java.awt.event.ActionEvent;
import view.VisualizarReceitaDespesaView;

public class VisualizarReceitaDespesaPresenter {
    private VisualizarReceitaDespesaView view;

    public VisualizarReceitaDespesaPresenter() {
        this.view = new VisualizarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        configuraBotaoDireita();
        configuraBotaoEsquerda();
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
}
