package presenter;

import java.awt.event.ActionEvent;
import view.CadastrarTarefasView;

public class CadastrarTarefasPresenter {
    private CadastrarTarefasView view;

    public CadastrarTarefasPresenter() {
        this.view = new CadastrarTarefasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        confirmarTarefa();
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        this.view.setVisible(true);
    }
        public void confirmarTarefa() {
        this.view.getJbBotaoConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              IDAOTarefa dao = TarefaSQLite();
                view.getJfDataTermino().getText();
                view.getJtCadastrarTarefa().getText();
                view.getJlListaMoradorEsquerda();
                view.getJlListaMoradorDireita();
                view.getJfDataTermino();
            }
        });
    }
    public void configuraBotaoDireita(){        
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