package presenter;

import com.pss.model.Republica;
import com.pss.model.RepublicaUsuarioLogado;
import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import java.awt.event.ActionEvent;
import view.CadastrarTarefasView;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.util.ArrayList;

public class CadastrarTarefasPresenter {
    private CadastrarTarefasView view;
    private Tarefa tarefa;

    public CadastrarTarefasPresenter() {
        this.view = new CadastrarTarefasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        confirmarCadastroTarefa();
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        this.view.setVisible(true);
    }
    
//     TESTANDO MÉTODO        
//        public void setarListaMoradorEsquerda(){
//            ArrayList<Usuario> usuarios;
//            IDAOUsuario dao = new UsuarioSQLite();
//            
//            usuarios = dao.obterUsuarios();
//            
//            for(int i=0; i<usuarios.size(); i++ ){
//            }
//        }
    
        public void confirmarCadastroTarefa() {
            this.view.getJbBotaoConfirmar().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
    //  *** deixando o código pronto pra depois colocar os comandos certinhos do banco ***
    //              IDAOTarefa dao = TarefaSQLite();
    //                this.tarefa = dao.CadastrarTarefa();
                    view.getJtDescricaoTarefa().setText(tarefa.getDescricao());
            // DESCOBRIR COMO PEGA ESSA LIST DO MORADOR E SETAR NO OUTRO LADO
                    view.getJlListaMoradorEsquerda();
                    view.getJlListaMoradorDireita();
                    view.getJfDataAgendamento().setText(tarefa.dataAgendamentoFormatada());      
                    view.getJfDataTermino().setText(tarefa.dataTerminoFormatada());
                }
            });
        }
        public void configuraBotaoDireita() {
            this.view.getJbBotaoDireita().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
        public void configuraBotaoEsquerda() {
            this.view.getJbBotaoEsquerda().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }
}