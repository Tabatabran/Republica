package presenter.manterReceitaDespesa;

import com.pss.model.ReceitaDespesa;
import com.pss.model.UsuarioLogado;
import dao.IDAOReceitaDespesa;
import dao.ReceitaDespesaSQLite;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import view.ManterReceitasDespesasView;

public class ManterReceitaDespesaPresenter {
    private ManterReceitasDespesasView view;

    public ManterReceitaDespesaPresenter() {
        this.view = new ManterReceitasDespesasView(); 
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        buscarReceitaDespesa();
        cadastrarReceitaDespesa();
        editarReceitaDespesa();
        realizarEstorno();
        verInformacoes();
        configuraView();
        this.view.setVisible(true);
    }
    
    public void buscarReceitaDespesa() {
        this.view.getJbBuscar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IDAOReceitaDespesa dao = new ReceitaDespesaSQLite();
                ArrayList<ReceitaDespesa> receitasDespesas;
                
                if (view.getJbBuscar().getSelectedIcon().equals("Pessoa")){
                    
                    receitasDespesas = dao.buscarReceitaDespesaPorPessoa(view.getJtCampoNome().getText());
                    verificaResultado(receitasDespesas);
                    
                }else{
                    
                    receitasDespesas = dao.buscarReceitaDespesaPorData(LocalDate.parse(view.getJtCampoNome().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    verificaResultado(receitasDespesas);
                    
                }
            }
        });
    }
    public void cadastrarReceitaDespesa(){        
        this.view.getJbCadastrarReceitaDespesa().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarReceitaDespesaPresenter(); 
            }
        });
    }
    public void editarReceitaDespesa(){        
        this.view.getJbEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificaSelecao() == true){
                    IDAOReceitaDespesa dao = new ReceitaDespesaSQLite();
                    int id = Integer.parseInt(String.valueOf(view.getJtTabelaReceitaDespesa().getValueAt(view.getJtTabelaReceitaDespesa().getSelectedRow(), 0)));
                    
                    CadastrarReceitaDespesaPresenter presenter = new CadastrarReceitaDespesaPresenter();
                    presenter.setState(new CadastrarReceitaDespesaEditarState(presenter));
                    presenter.mudaState(dao.buscarReceitaDespesa(id));
                }
            }
        });
    }
    public void realizarEstorno(){        
        this.view.getJbRealizarEstorno().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
        });
    }
    public void verInformacoes(){        
        this.view.getJbVerInformacoes().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificaSelecao() == true){
                    IDAOReceitaDespesa dao = new ReceitaDespesaSQLite();
                    int id = Integer.parseInt(String.valueOf(view.getJtTabelaReceitaDespesa().getValueAt(view.getJtTabelaReceitaDespesa().getSelectedRow(), 0)));
                    
                    CadastrarReceitaDespesaPresenter presenter = new CadastrarReceitaDespesaPresenter();
                    presenter.setState(new CadastrarReceitaDespesaVisualizarState(presenter));
                    presenter.mudaState(dao.buscarReceitaDespesa(id));
                }
            }
        });
    }
    
    public boolean verificaSelecao(){
        if(view.getJtTabelaReceitaDespesa().getSelectedRow() < 0){
            JOptionPane.showMessageDialog(null, "Selecione uma linha da tabela");
        } else {
            return true;
        }
        
        return false;
        
    }
    
    public void configuraTabela(ArrayList<ReceitaDespesa> receitasDespesas){
        DefaultTableModel model = (DefaultTableModel) view.getJtTabelaReceitaDespesa().getModel();
        model.setNumRows(0);
        
        view.getJtTabelaReceitaDespesa().getColumnModel().getColumn(0).setMinWidth(0);
        view.getJtTabelaReceitaDespesa().getColumnModel().getColumn(0).setMaxWidth(0);
                    
        for(ReceitaDespesa receitaDespesa: receitasDespesas){
            String nomes = "";
            
            for(String nome : receitaDespesa.getMoradoresparticipantes()){
                nomes += nome + ", ";
            }
            
            model.addRow(new Object[]{
                receitaDespesa.getCodigo(),
                receitaDespesa.getTipo(),
                receitaDespesa.getDescricao(),
                String.valueOf(receitaDespesa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))),
                String.valueOf(receitaDespesa.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))),
                String.valueOf(receitaDespesa.getValor()),
                receitaDespesa.getPeriodicidade(),
                nomes,
                String.valueOf(receitaDespesa.getValorParcela())
            });
            
            view.getJtTabelaReceitaDespesa().setModel(model);
        }
    }
    
    public void configuraView(){
        IDAOReceitaDespesa dao = new ReceitaDespesaSQLite();
        
        configuraTabela(dao.buscarReceitasDespesas(UsuarioLogado.getInstancia().getRepublicaAtual()));
        
    }
    
    public void verificaResultado(ArrayList<ReceitaDespesa> receitasDespesas){
        if(receitasDespesas == null){
            JOptionPane.showMessageDialog(null, "Receita / Despesa não encontrada");
        }else{
            configuraTabela(receitasDespesas);
        }
        
    }
}


