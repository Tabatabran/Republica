package presenter;

import java.awt.event.ActionEvent;
import view.RegistrarConfirmacaoTarefaView;

public class RegistrarConfirmacaoTarefaPresenter {
    private RegistrarConfirmacaoTarefaView view;

    public RegistrarConfirmacaoTarefaPresenter() {
        this.view = new RegistrarConfirmacaoTarefaView();
        configuraView();
        this.view.setVisible(true);
    }
    
    public void configuraView() {
        this.view.getJbBotaoRealizada().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }    
}
