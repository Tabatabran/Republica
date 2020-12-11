package presenter;

import com.pss.model.Republica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManterMoradorView;
import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import dao.IDAORepublica;
import dao.RepublicaSQLite;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import presenter.HistoricoMoradorPresenter;


public class ManterMoradorPresenter {
    private ManterMoradorView view;
    
    public ManterMoradorPresenter(){
        this.view = new ManterMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        prencherTabelas();
        removerDaRepublica();
        verHistorico();
        convidar();
        editar();
        this.view.setVisible(true);
    }
    
    public void editar(){
        this.view.getjButtonEditar().addActionListener((e) -> {
            String morador;
            int linha = this.view.getjTableMorador().getSelectedRows()[0];
            if(linha != -1){
                String nome_morador = (String) this.view.getjTableMorador().getValueAt(linha, 0);
                new EditarMorador(nome_morador);
            }
            else{
                JOptionPane.showMessageDialog(null, "Nunhum morador selecionado");
            }
        });
    }
    
    public void verHistorico(){
        this.view.getjButtonHistorico().addActionListener(((e) -> {
            if(this.view.getjTableMorador().getSelectedRows().length > 0){
                int linha = this.view.getjTableMorador().getSelectedRows()[0];
                String nome_morador = (String) this.view.getjTableMorador().getValueAt(linha, 0);    
                new HistoricoMoradorPresenter(nome_morador);
            }
        }));
    }
    
    public void removerDaRepublica(){
        this.view.getjButtonRemover().addActionListener((ActionEvent e) -> {
            if(this.view.getjTableMorador().getSelectedRows().length > 0){
                int linha = this.view.getjTableMorador().getSelectedRows()[0];
                String nome_morador = (String) this.view.getjTableMorador().getValueAt(linha, 0);
                // "remover" a linha do usuario removido
                for(int i = 0; i < 3; i++){
                    this.view.getjTableMorador().setValueAt("", linha, i);
                }
                IDAOUsuario dao = new UsuarioSQLite();
                IDAORepublica daoRepublica = new RepublicaSQLite();

                String republica = dao.consultarRepublicaDoUsuario(nome_morador);
                daoRepublica.incrementarVagasDisponiveis(republica);
                dao.deletarRepublicaAtualDoUsuario(nome_morador);
                
                JOptionPane.showMessageDialog(null, "Morador removido");
            }
        });
        
    }
    
    public void prencherTabelas(){
        ArrayList<Usuario> usuarios;
        IDAOUsuario dao = new UsuarioSQLite();
        IDAORepublica daoRepublica = new RepublicaSQLite();
        Republica republicaLogada = daoRepublica.consultarRepublica(UsuarioLogado.getInstancia().getRepublicaAtual());
        if(republicaLogada != null){
            usuarios = dao.consultarUsuariosPorRepublica(republicaLogada.getNome());
        
            for(int i=0; i<usuarios.size(); i++ ){
                view.getjTableMorador().setValueAt(usuarios.get(i).getNome(), i, 0);
                //view.getjTableMorador().setValueAt(usuarios.get(i).get, i, 0);
                //view.getjTableMorador().setValueAt(usuarios.get(i).getNome(), i, 0);
            }
        }
    }
    
    public void convidar(){
        this.view.getjButtonConvidar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ConvidarMoradorPresenter();
            }
        });
    }
}
