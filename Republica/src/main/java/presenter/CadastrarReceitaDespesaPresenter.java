package presenter;

import java.awt.event.ActionEvent;
import view.CadastrarReceitaDespesaView;

public class CadastrarReceitaDespesaPresenter {
    private CadastrarReceitaDespesaView view;

    public CadastrarReceitaDespesaPresenter() {
        this.view = new CadastrarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        confirmarCadastro();
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
    public void confirmarCadastro(){        
        this.view.getJbConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}