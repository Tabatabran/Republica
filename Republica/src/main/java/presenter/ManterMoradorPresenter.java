package presenter;

import com.pss.model.Republica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ManterMoradorView;
import com.pss.model.RepublicaUsuarioLogado;
import com.pss.model.Usuario;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.util.ArrayList;

public class ManterMoradorPresenter {
    private ManterMoradorView view;
    
    public ManterMoradorPresenter(){
        this.view = new ManterMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        prencherTabelas();
        this.convidar();
        this.view.setVisible(true);
    }
    
    public void prencherTabelas(){
        ArrayList<Usuario> usuarios;
        IDAOUsuario dao = new UsuarioSQLite();
        Republica republicaLogada = RepublicaUsuarioLogado.getInstancia();
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