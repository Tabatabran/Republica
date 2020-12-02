package presenter;

import com.pss.model.UsuarioLogado;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ConvidarMoradorView;

public class ConvidarMoradorPresenter {
    private ConvidarMoradorView view;
    
    public ConvidarMoradorPresenter(){
        this.view = new ConvidarMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        convidar();
        this.view.setVisible(true);
    }
    
    private void convidar(){
        this.view.getjButtonConvidar().addActionListener((ActionEvent e) -> {
            String nome_morador = this.view.getjTextFieldNomeConvidar().getText();
            IDAOUsuario dao = new UsuarioSQLite();
            dao.adicionarRepulicaDoUsuario(nome_morador, UsuarioLogado.getInstancia().getRepublicaAtual());
        });
    }
}
