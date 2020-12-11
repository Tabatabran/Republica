package presenter.manterReceitaDespesa;

import business.CalculoParcelaDespesaPorMorador;
import business.ICalculoParcelasDespesa;
import com.pss.model.ReceitaDespesa;
import com.pss.model.UsuarioLogado;
import dao.IDAOReceitaDespesa;
import dao.IDAOUsuario;
import dao.ReceitaDespesaSQLite;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import view.CadastrarReceitaDespesaView;

public class CadastrarReceitaDespesaPresenter {

    private CadastrarReceitaDespesaView view;
    private ArrayList<String> nomesEsquerda;
    private ArrayList<String> nomesDireita;
    private DefaultListModel modelEsquerda = new DefaultListModel();
    private DefaultListModel modelDireita = new DefaultListModel();
    private CadastrarReceitaDespesaState state;

    public CadastrarReceitaDespesaPresenter() {
        this.view = new CadastrarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        confirmarCadastro();
        configuraViewCadastrar();
        this.view.setVisible(true);
    }
    
    public void setState(CadastrarReceitaDespesaState state){
        this.state = state;
    }
    
    public void mudaState(ReceitaDespesa receitadespesa){
        state.configuraView(receitadespesa);
    }

    public void configuraBotaoDireita() {
        this.view.getJbBotaoDireita().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getJlListaMoradorEsquerda().getSelectedValue() == null){
                
                }else{
                    modelDireita.addElement(view.getJlListaMoradorEsquerda().getSelectedValue());
                    modelEsquerda.removeElementAt(view.getJlListaMoradorEsquerda().getSelectedIndex());
                    
                    view.getJlListaMoradorDireita().setModel(modelDireita);
                    view.getJlListaMoradorEsquerda().setModel(modelEsquerda);
                }
            }
        });
    }

    public void configuraBotaoEsquerda() {
        this.view.getJbBotaoEsquerda().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getJlListaMoradorDireita().getSelectedValue() == null){
                
                }else{
                    modelEsquerda.addElement(view.getJlListaMoradorDireita().getSelectedValue());
                    modelDireita.removeElementAt(view.getJlListaMoradorDireita().getSelectedIndex());
                    
                    view.getJlListaMoradorEsquerda().setModel(modelEsquerda);
                    view.getJlListaMoradorDireita().setModel(modelDireita);
                }
            }
        });
    }

    public void confirmarCadastro() {
        this.view.getJbConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view.getJtDescricaoReceitaDespesa().getText().isEmpty() || view.getJtValor().getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Informe o valor e a descrição!");
                }else{
                    ArrayList<String> nomesMoradores = new ArrayList<>();
                    
                    for (int i = 0; i < modelDireita.getSize(); i++){
                        nomesMoradores.add((String) modelDireita.getElementAt(i));
                    }
                    
                    String tipo;
                    String periodicidade;
                    
                    if(view.getJrbReceita().isSelected()){
                        tipo = "Receita";
                    }else{
                        tipo = "Despesa";
                    }
                    
                    if(view.getJrbIndefinido().isSelected()){
                        periodicidade = "Indefinido";
                    }else if (view.getJrbAnual().isSelected()){
                        periodicidade = "Anual";
                    }else if (view.getJrbMensal().isSelected()){
                        periodicidade = "Mensal";
                    }else{
                        periodicidade = "Semanal";
                    }
                    
                    ReceitaDespesa receitaDespesa = new ReceitaDespesa(tipo,
                        view.getJtDescricaoReceitaDespesa().getText(),
                        LocalDate.parse(view.getJftDataCadastro().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        Double.parseDouble(view.getJtValor().getText()),
                        periodicidade,
                        nomesMoradores);
                    
                    if (!view.getJftDataVencimento().getText().isEmpty()){
                        receitaDespesa.setDataVencimento(LocalDate.parse(view.getJftDataVencimento().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    }
                    
                    ICalculoParcelasDespesa calculoParcela = new CalculoParcelaDespesaPorMorador();
                    receitaDespesa.setValorParcela(calculoParcela.calcular(receitaDespesa)); 
                    
                    IDAOReceitaDespesa dao = new ReceitaDespesaSQLite();
                    dao.cadastrarReceitaDespesa(receitaDespesa);
                    
                    view.dispose();
                }
            }
        });
    }
    
    public void configuraViewCadastrar() {
        IDAOUsuario dao = new UsuarioSQLite();
        nomesEsquerda = dao.obterUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
        
        for (String s: nomesEsquerda) {
            modelEsquerda.addElement(s);
        }

        view.getJlListaMoradorEsquerda().setModel(modelEsquerda);
        
        view.getJrbDespesa().setSelected(true);
        view.getJrbIndefinido().setSelected(true);
        view.getJftDataCadastro().setText(String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        view.getjLabelValorParcela().setVisible(false);
        view.getJtValorParcela().setVisible(false);

    }
    
    public void configuraViewEditar(ReceitaDespesa receitadespesa){
        preencheCampos(receitadespesa);
        
        view.getJbConfirmar().setText("Editar");
    }
    
    public void configuraViewVizualizar(ReceitaDespesa receitadespesa){
        preencheCampos(receitadespesa);
        
        view.getJftDataCadastro().setEnabled(false);
        view.getJbBotaoDireita().setEnabled(false);
        view.getJbBotaoEsquerda().setEnabled(false);
        view.getJbConfirmar().setVisible(false);
        view.getJftDataVencimento().setEnabled(false);
        view.getJrbAnual().setEnabled(false);
        view.getJrbDespesa().setEnabled(false);
        view.getJrbIndefinido().setEnabled(false);
        view.getJrbMensal().setEnabled(false);
        view.getJrbReceita().setEnabled(false);
        view.getJrbSemanal().setEnabled(false);
        view.getJtDescricaoReceitaDespesa().setEnabled(false);
        view.getJtValor().setEnabled(false);
        view.getJtValorParcela().setEnabled(false);
    }
    
    public void preencheCampos(ReceitaDespesa receitadespesa){
        view.getJftDataCadastro().setText(String.valueOf(receitadespesa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        view.getJftDataVencimento().setText(String.valueOf(receitadespesa.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        view.getJtDescricaoReceitaDespesa().setText(receitadespesa.getDescricao());
        view.getJtValor().setText(String.valueOf(receitadespesa.getValor()));
        view.getJtValorParcela().setText(String.valueOf(receitadespesa.getValorParcela()));
        
        if(receitadespesa.getTipo().equals("Receita")){
            view.getJrbReceita().setSelected(true);
        }else{
            view.getJrbDespesa().setSelected(true);
        }
        
        if(receitadespesa.getPeriodicidade().equals("Indefinido")){
            view.getJrbIndefinido().setSelected(true);
        }else if (receitadespesa.getPeriodicidade().equals("Anual")){
            view.getJrbAnual().setSelected(true);
        }else if (receitadespesa.getPeriodicidade().equals("Mensal")){
            view.getJrbMensal().setSelected(true);
        }else{
            view.getJrbSemanal().setSelected(true);
        }
        
        view.getJtValorParcela().setEnabled(false);
        
        for(String nome: receitadespesa.getMoradoresparticipantes()){
            modelDireita.addElement(nome);
        }
        
        view.getJlListaMoradorDireita().setModel(modelDireita);
        
        IDAOUsuario dao = new UsuarioSQLite();
        nomesEsquerda = dao.obterUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
        
        for (String nome: receitadespesa.getMoradoresparticipantes()){
            for (String nomeMoradores: nomesEsquerda){
                if(nome.equals(nomeMoradores)){
                    modelEsquerda.removeElement(nomeMoradores);
                }
            }
        }
        
        view.getJlListaMoradorEsquerda().setModel(modelEsquerda);
    }
    
}
