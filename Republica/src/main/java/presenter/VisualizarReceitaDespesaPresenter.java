package presenter;

import java.awt.event.ActionEvent;
import view.VisualizarReceitaDespesaView;

public class VisualizarReceitaDespesaPresenter {
    private VisualizarReceitaDespesaView view;

    public VisualizarReceitaDespesaPresenter() {
        this.view = new VisualizarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
    }
}
