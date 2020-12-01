package presenter;

import java.awt.event.ActionEvent;
import view.RegistrarConfirmacaoTarefaView;

public class RegistrarConfirmacaoTarefaPresenter {
    private RegistrarConfirmacaoTarefaView view;

    public RegistrarConfirmacaoTarefaPresenter() {
        this.view = new RegistrarConfirmacaoTarefaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        configuraTarefaRealizada();
        this.view.setVisible(true);
    }
    
    public void configuraTarefaRealizada() {
        this.view.getJbBotaoRealizada().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }    
}