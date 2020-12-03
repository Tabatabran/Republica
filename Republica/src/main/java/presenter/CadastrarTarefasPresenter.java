package presenter;

import com.pss.model.Republica;
import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import java.awt.event.ActionEvent;
import view.CadastrarTarefasView;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class CadastrarTarefasPresenter {
    private CadastrarTarefasView view;
    private Tarefa tarefa;

    public CadastrarTarefasPresenter() {
        this.view = new CadastrarTarefasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        preencherMoradoresRepublica();
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
                    tarefa.setDescricao(view.getJtDescricaoTarefa().getText());
                    tarefa.setDataAgendamento(LocalDate.parse(view.getJfDataAgendamento().getText()));
                    tarefa.setDataTermino(LocalDate.parse(view.getJfDataTermino().getText()));
                    for(int i=0;i<=view.getJlListaMoradorDireita().getModel().getSize();i++){
                        //tarefa.addResponsavel();
                    }
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
                    DefaultListModel model;
                    
                    if(view.getJlListaMoradorEsquerda().getSelectedIndex()>=0){
                        System.out.println("deu certo");
                        model= (DefaultListModel) view.getJlListaMoradorDireita().getModel();
                        model.addElement(view.getJlListaMoradorEsquerda().getSelectedValue());
                        
                        model=(DefaultListModel) view.getJlListaMoradorEsquerda().getModel();
                        model.remove(view.getJlListaMoradorEsquerda().getSelectedIndex());
                        
                        view.getJlListaMoradorDireita().revalidate();
                        view.getJlListaMoradorEsquerda().revalidate();
                        view.repaint();
                        view.getJlListaMoradorEsquerda().updateUI();
                         view.getJlListaMoradorDireita().updateUI();
                        
                        
                    }
                }
            });
        }
        public void configuraBotaoEsquerda() {
            this.view.getJbBotaoEsquerda().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                     DefaultListModel model;
                    
                    if(view.getJlListaMoradorDireita().getSelectedIndex()>=0){
                        
                        //view.getJlListaMoradorEsquerda().remove(view.getJlListaMoradorEsquerda().getSelectedIndex());
                        
                        
                        model= (DefaultListModel) view.getJlListaMoradorEsquerda().getModel();
                        model.addElement(view.getJlListaMoradorDireita().getSelectedValue());
                        
                        model=(DefaultListModel) view.getJlListaMoradorDireita().getModel();
                        model.remove(view.getJlListaMoradorDireita().getSelectedIndex());
                        view.getJlListaMoradorEsquerda().revalidate();
                        view.repaint();
                        //view.getJlListaMoradorEsquerda().updateUI();
                        
                    }
                }
            });
        }
        public void preencherMoradoresRepublica(){
            DefaultListModel model;
            model=(DefaultListModel) view.getJlListaMoradorEsquerda().getModel();
            IDAOUsuario dao = new UsuarioSQLite();
            ArrayList<String> moradores=dao.obterUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
            for(String s:moradores ){
                model.addElement(s);
            }
            view.getJlListaMoradorEsquerda().revalidate();
            view.repaint();
        }
}