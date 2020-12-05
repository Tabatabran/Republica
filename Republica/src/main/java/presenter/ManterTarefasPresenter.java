package presenter;

import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import dao.IDAOTarefas;
import dao.IDAOUsuario;
import dao.TarefasSQLite;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.ManterTarefasView;

public class ManterTarefasPresenter {
    private ManterTarefasView view;
    
    public ManterTarefasPresenter() {
        this.view  = new ManterTarefasView();
        this.view.setLocationRelativeTo(null);
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        buscarTarefa();
        cadastrarTarefa();
        editarTarefa();
        excluirTarefa();
        this.view.setVisible(true);
    }
   
    public void buscarTarefa() {
        this.view.getJbBuscar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int opcao=view.getJcBuscar().getSelectedIndex();
               if(opcao==0){
                   if(view.getTfCampoNome().getText()!=null){
                       ArrayList<Usuario> usuarios=new ArrayList<>();
                       IDAOUsuario dao = new UsuarioSQLite();
                       usuarios=dao.buscarUsuariosNaRepublicaAtualPorNome(UsuarioLogado.getInstancia().getRepublicaAtual(),  view.getTfCampoNome().getText());
                       
                       IDAOTarefas daoTarefa = new TarefasSQLite();
                       ArrayList<Tarefa> tarefas = new ArrayList<>();
                       
                       DefaultTableModel model = (DefaultTableModel) view.getJtTabelaManterTarefa().getModel();
                       model.setNumRows(0);
                       for(Usuario u: usuarios){
                           
                           
                           tarefas=daoTarefa.buscarTarefasDoUsuario(u);
                           for(Tarefa tarefa:tarefas){
                                    ArrayList<String> responsaveis = daoTarefa.buscarResponsaveisDaTarefa(tarefa.getCodigo());
                                    String responsaveisCompilado="";
                                    for(String s: responsaveis){
                                        responsaveisCompilado = responsaveisCompilado+s+" ";
                                    }
                                    model.addRow(new Object[]{
                                    tarefa.getDescricao(),
                                    responsaveisCompilado,
                                    tarefa.getDataAgendamento(),
                                    tarefa.getDataTermino(),
                                    tarefa.isFinalizada()});
                            }
                                    
                       }
                   }else{
                        JOptionPane pane = new JOptionPane();
                        pane.showConfirmDialog(null, "Preencha o nome do morador.");
                   }
                   
               }else if(opcao==1){
                   
               }else{
                   JOptionPane pane = new JOptionPane();
                   pane.showConfirmDialog(null, "Selecione uma opção de busca.");
               }
            }
        });
    }
    public void cadastrarTarefa(){        
        this.view.getJbCadastrarTarefa().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarTarefasPresenter();
                view.setVisible(false);
            }
        });
    }
    public void editarTarefa(){
        this.view.getJbEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {               
                    String nomes=(String)view.getJtTabelaManterTarefa().getValueAt(view.getJtTabelaManterTarefa().getSelectedRow(), 1);
                    String[] responsaveisString;
                    responsaveisString=nomes.split(" ");
                    ArrayList<Usuario> usuarios=new ArrayList<>();
                    for(int i=0;i<responsaveisString.length;i++){
                        Usuario usuario=new Usuario();
                        usuario.setNome(responsaveisString[i]);
                        usuarios.add(usuario);
                    }
                    
                    Tarefa tarefa;               
                    tarefa = new Tarefa((LocalDate)view.getJtTabelaManterTarefa().getValueAt(view.getJtTabelaManterTarefa().getSelectedRow(),2), 
                            //view.getJtTabelaManterTarefa().getValueAt(view.getJtTabelaManterTarefa().getSelectedRow(),1), 
                             usuarios,
                            (String)view.getJtTabelaManterTarefa().getValueAt(view.getJtTabelaManterTarefa().getSelectedRow(),0), 
                            (LocalDate)view.getJtTabelaManterTarefa().getValueAt(view.getJtTabelaManterTarefa().getSelectedRow(),3));
                    
                            new CadastrarTarefasPresenter(tarefa);
              
            }
        });
    }
    public void excluirTarefa(){
        this.view.getJbExcluir().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
}