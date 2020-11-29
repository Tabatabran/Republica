package presenter;

import java.awt.event.ActionEvent;
import view.ListarReceitaDespesaView;

public class ListarReceitaDespesaPresenter {
    private ListarReceitaDespesaView view;

    public ListarReceitaDespesaPresenter() {
        this.view = new ListarReceitaDespesaView();
        configuraView();
        this.view.setVisible(true);
    }
    
    public void configuraView() {
        this.view.getJbConfimarPagamentoRecebimento().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
        
        this.view.getJbConsultarResultadoMensal().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });        
    }
}
