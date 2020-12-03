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


public class ManterMoradorPresenter {
    private ManterMoradorView view;
    
    public ManterMoradorPresenter(){
        this.view = new ManterMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        prencherTabelas();
        removerDaRepublica();
        this.convidar();
        this.view.setVisible(true);
    }
    
    public void removerDaRepublica(){
        this.view.getjButtonRemover().addActionListener((ActionEvent e) -> {
            if(this.view.getjTableMorador().getSelectedRows().length > 0){
                int linha = this.view.getjTableMorador().getSelectedRows()[0];
                String nome_morador = (String) this.view.getjTableMorador().getValueAt(linha, 0);    
                IDAOUsuario dao = new UsuarioSQLite();
                dao.deletarRepublicaAtualDoUsuario(nome_morador);
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
