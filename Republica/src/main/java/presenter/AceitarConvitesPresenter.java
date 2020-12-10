/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.UsuarioLogado;
import dao.ConvitesSQLite;
import dao.IDAOConvites;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import view.AceitarConvitesView;

/**
 *
 * @author vitor
 */
public class AceitarConvitesPresenter {
    private AceitarConvitesView view;

    public AceitarConvitesPresenter() {
        this.view = new AceitarConvitesView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        buscarConvites();
        aceitarConvite();
        recusarConvite();
        this.view.setVisible(true);
    }
    
    private void recusarConvite(){
        this.view.getjButtonRecusar().addActionListener((e) -> {
            int linha = this.view.getjTable().getSelectedRow();
            if(linha != -1){
                String nome_morador = (String) this.view.getjTable().getValueAt(linha, 0);
                IDAOConvites dao = new ConvitesSQLite();
                dao.removerConvite(nome_morador, UsuarioLogado.getInstancia().getRepublicaAtual(), true);

                // "deletar" a linha
                for(int i = 0; i < 3; i++){
                    this.view.getjTable().setValueAt("", linha, i);
                }    
            }
            else{
                JOptionPane.showMessageDialog(null, "Nunhum convite selecionado");
            }
        });
    }
    
    private void aceitarConvite(){
        this.view.getjButtonAceitar().addActionListener((e) -> {
            int linha = this.view.getjTable().getSelectedRow();
            if(linha != -1){
                String republica = (String) this.view.getjTable().getValueAt(linha, 0);
                IDAOConvites dao = new ConvitesSQLite();
                dao.aceitarConviteRepublica(republica, UsuarioLogado.getInstancia().getLogin());
                JOptionPane.showMessageDialog(null, "Convite aceito, republica atual atualizada");
                // "deletar" a linha
                for(int i = 0; i < 3; i++){
                    this.view.getjTable().setValueAt("", linha, i);
                }    
            }
            else{
                JOptionPane.showMessageDialog(null, "Nunhum convite selecionado");
            }
        });
    }
    
    private void buscarConvites(){
        ArrayList<String> convites;
        
        IDAOConvites dao = new ConvitesSQLite();
        convites = dao.consultarConvitesParaMorador(UsuarioLogado.getInstancia().getLogin());
        
        if(convites == null) return;
        
        for(int i = 0; i < convites.size(); i++){
            this.view.getjTable().setValueAt(convites.get(i), i, 0);
        }
    }
}
