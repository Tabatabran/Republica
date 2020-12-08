package presenter;

import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import dao.ConvitesSQLite;
import dao.IDAOConvites;
import dao.IDAOUsuario;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.ConvidarMoradorView;

public class ConvidarMoradorPresenter {
    private ConvidarMoradorView view;
    
    public ConvidarMoradorPresenter(){
        this.view = new ConvidarMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        convidar();
        mostrarSolicitacoes();
        aceitar();
        recusar();
        this.view.setVisible(true);
    }
    
    private void recusar(){
        this.view.getjButtonRecusar().addActionListener((e) -> {
            int linha = this.view.getjTable1().getSelectedRow();
            if(linha != -1){
                String nome_morador = (String) this.view.getjTable1().getValueAt(linha, 0);
                IDAOConvites dao = new ConvitesSQLite();
                dao.removerConvite(nome_morador, UsuarioLogado.getInstancia().getRepublicaAtual(), false);
                // apagar a linha do convite
                for(int i = 0; i < 3; i++){
                    this.view.getjTable1().setValueAt("", linha, i);
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Nenhum convite selecionado");
            }
        });
    }
    
    private void aceitar(){
        this.view.getjButtonAceitar().addActionListener((e) -> {
            int linha = this.view.getjTable1().getSelectedRow();
            if(linha != -1){
                String nome_morador = (String) this.view.getjTable1().getValueAt(linha, 0);
                IDAOConvites dao = new ConvitesSQLite();
                dao.aceitarConviteMorador(nome_morador, UsuarioLogado.getInstancia().getRepublicaAtual());
                // apagar a linha do convite
                for(int i = 0; i < 3; i++){
                    this.view.getjTable1().setValueAt("", linha, i);
                }
                
                JOptionPane.showMessageDialog(null, String.format("Convite foi aceito, %s foi adicionado à república", nome_morador));
            }
            else{
                JOptionPane.showMessageDialog(null, "Nenhum convite selecionado");
            }
        });
    }
    
    private void mostrarSolicitacoes(){
        IDAOConvites dao = new ConvitesSQLite();
        ArrayList<String> convites = dao.consultarConvitesParaRepublica(UsuarioLogado.getInstancia().getRepublicaAtual());
        for(int i = 0; i < convites.size(); i++){
            IDAOUsuario daoUsuario = new UsuarioSQLite();
            Usuario usuario = daoUsuario.obterUsuario(convites.get(i));
            view.getjTable1().setValueAt(convites.get(i), i, 0);
            // TODO descomentar quando usuario possuir os indices.
            //view.getjTable1().setValueAt(usuario.get, i, 1);
            //view.getjTable1().setValueAt(usuario.get, i, 2);
        }
    }
    
    private void convidar(){
        this.view.getjButtonConvidar().addActionListener((ActionEvent e) -> {
            String nome_morador = this.view.getjTextFieldNomeConvidar().getText();
            // checar se o morador existe
            IDAOUsuario daoUsuario = new UsuarioSQLite();
            if(daoUsuario.obterUsuario(nome_morador) != null){
                IDAOConvites dao = new ConvitesSQLite();
                dao.adicionarConvite(UsuarioLogado.getInstancia().getRepublicaAtual(), nome_morador, true);    
                JOptionPane.showMessageDialog(null, "Convite enviado");
            }
            else{
                JOptionPane.showMessageDialog(null, "Usuário não existe");
            }            
        });
    }
}
