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
    private String[] nomesEsquerda;
    private String[] nomesDireita;
    private DefaultListModel modelEsquerda = new DefaultListModel();
    private DefaultListModel modelDireita = new DefaultListModel();

    public CadastrarReceitaDespesaPresenter() {
        this.view = new CadastrarReceitaDespesaView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        configuraBotaoDireita();
        configuraBotaoEsquerda();
        confirmarCadastro();
        configuraView();
        this.view.setVisible(true);
    }

    public void configuraView() {
        IDAOUsuario dao = new UsuarioSQLite();
        nomesEsquerda = dao.obterUsuariosNaRepublicaAtual(UsuarioLogado.getInstancia().getRepublicaAtual());
        
        for (int i = 0; i < nomesEsquerda.length; i++) {
            modelEsquerda.addElement(nomesEsquerda[i]); 
        }

        view.getJlListaMoradorEsquerda().setModel(modelEsquerda);
        
        view.getJrbDespesa().setSelected(true);
        view.getJrbIndefinido().setSelected(true);
        view.getJftDataCadastro().setText(String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

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
}
