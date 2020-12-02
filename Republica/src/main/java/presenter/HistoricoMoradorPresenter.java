/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import view.HistoricoMoradorView;
import dao.IDAOUsuarioRepublica;
import dao.UsuarioRepublicaSQLite;
import com.pss.model.UsuarioLogado;
import com.pss.model.HistoricoRepublica;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thiago
 */
public class HistoricoMoradorPresenter {
    private HistoricoMoradorView view;
    protected String nome_usuario;
    
    public HistoricoMoradorPresenter(String nome_usuario) {
        this.nome_usuario = nome_usuario;
        this.view= new HistoricoMoradorView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        exibirHistorico();
        this.view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    public void exibirHistorico(){
        IDAOUsuarioRepublica dao = new UsuarioRepublicaSQLite();
        ArrayList<HistoricoRepublica> historico = dao.obterRegistro(UsuarioLogado.getInstancia().getLogin());
        
        DefaultTableModel model = (DefaultTableModel) this.view.getjTableHistorico().getModel();
        model.setNumRows(0);
        for(HistoricoRepublica f: historico ){
            model.addRow(new Object[]{
                f.getNomeRepublica(),
                f.getDataIngresso(),
                f.getDataSaida(),
                null,
                null,
                null,
                null,
                null
                });
        }
        this.view.getjLabelNome().setText(nome_usuario);
    }
    
    
    
}
