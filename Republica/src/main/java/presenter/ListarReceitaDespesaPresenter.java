package presenter;

import java.awt.event.ActionEvent;
import view.ListarReceitaDespesaView;

public class ListarReceitaDespesaPresenter {
    private ListarReceitaDespesaView view;

    public ListarReceitaDespesaPresenter() {
        this.view = new ListarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        confirmarPagamentoRecebimento();
        consultarResultadoMensal();
        this.view.setVisible(true);
    }
    
    public void confirmarPagamentoRecebimento() {
        this.view.getJbConfimarPagamentoRecebimento().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void consultarResultadoMensal(){        
        this.view.getJbConsultarResultadoMensal().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });        
    }
}