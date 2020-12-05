package presenter;

import com.pss.model.Republica;
import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import dao.IDAOTarefas;
import java.awt.event.ActionEvent;
import view.CadastrarTarefasView;
import dao.IDAOUsuario;
import dao.TarefasSQLite;
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
    public CadastrarTarefasPresenter(Tarefa tarefa){        
        this.view = new CadastrarTarefasView();        
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
      
        preencherTarefa(tarefa);
        preencherMoradoresRepublica();
        confirmarCadastroTarefa();
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        this.view.setVisible(true);
    }
    

        public void preencherTarefa(Tarefa tarefa){
            LocalDate data=tarefa.getDataAgendamento();
            DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            view.getJfDataAgendamento().setText(data.format(formatter).toString());
            data=tarefa.getDataTermino();
            view.getJfDataTermino().setText(data.format(formatter).toString());
            view.getJtDescricaoTarefa().setText(tarefa.getDescricao());
             DefaultListModel model;
            model=(DefaultListModel) view.getJlListaMoradorDireita().getModel();
            for(Usuario usuario:tarefa.getResponsaveis()){
                model.addElement(usuario.getNome());
            }
        }
        public void confirmarCadastroTarefa() {
            this.view.getJbBotaoConfirmar().addActionListener(new java.awt.event.ActionListener() {
                @Override
                
                public void actionPerformed(ActionEvent e) {
   
                    DefaultListModel model;
                    model= (DefaultListModel) view.getJlListaMoradorDireita().getModel();
                    //pegando os moradores da republica o nome de usuarios deles será usado
                    ArrayList<Usuario> moradoresDaRepublica = new ArrayList<>();
                    IDAOUsuario udao = new UsuarioSQLite();
                    moradoresDaRepublica=udao.buscarUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
                    
                    ArrayList<Usuario> responsaveisTarefa = new ArrayList<>();
                    for(int i=0;i<view.getJlListaMoradorDireita().getModel().getSize();i++){
                        for(Usuario u:moradoresDaRepublica){
                            if(u.getNome()!=null){
                                if(u.getNome().equals((String)model.getElementAt(i)))                               
                                responsaveisTarefa.add(u);
                            }
                        }
                        
                    }
                    
                    tarefa= new Tarefa(LocalDate.parse(view.getJfDataAgendamento().getText(),DateTimeFormatter.ofPattern("dd/MM/yyyy" )), responsaveisTarefa,
                            view.getJtDescricaoTarefa().getText(), LocalDate.parse(view.getJfDataTermino().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy" )));
                   
                    
                   
                    IDAOTarefas dao = new TarefasSQLite();
                    
                    dao.novaTarefa(tarefa);
                    
                    
                }
            });
        }
        public void configuraBotaoDireita() {
            this.view.getJbBotaoDireita().addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    DefaultListModel model;
                    
                    if(view.getJlListaMoradorEsquerda().getSelectedIndex()>=0){
                       // System.out.println("deu certo");
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
            ArrayList<String> aux=new ArrayList<>();
            for(int i=0;i<view.getJlListaMoradorDireita().getModel().getSize();i++){
                aux.add(view.getJlListaMoradorDireita().getModel().getElementAt(i));
            }
            DefaultListModel model;
            model=(DefaultListModel) view.getJlListaMoradorEsquerda().getModel();
            IDAOUsuario dao = new UsuarioSQLite();
            ArrayList<String> moradores=dao.obterUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
            for(String s:moradores ){             
                
               if(!aux.contains(s))
                model.addElement(s);
            }
            view.getJlListaMoradorEsquerda().revalidate();
            view.repaint();
        }
}