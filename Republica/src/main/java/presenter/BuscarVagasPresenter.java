/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.UsuarioLogado;
import dao.ConvitesSQLite;
import dao.IDAOConvites;
import dao.IDAORepublica;
import dao.RepublicaSQLite;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import view.BuscarVagasView;

/**
 *
 * @author vitor
 */
public class BuscarVagasPresenter {
    private BuscarVagasView view;
    
    public BuscarVagasPresenter(){
        this.view = new BuscarVagasView();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        buscarRepublicas();
        solicitar();
        this.view.setVisible(true);
    }
    
    private void solicitar(){
        this.view.getjButtonSolicitar().addActionListener((e) -> {
            int linha = this.view.getjTable1().getSelectedRow();
            if(linha != -1){
                String republica = (String) this.view.getjTable1().getValueAt(linha, 0);
                if(!this.view.getjTable1().getValueAt(linha, 2).equals("0")){
                    IDAOConvites dao = new ConvitesSQLite();
                    dao.adicionarConvite(UsuarioLogado.getInstancia().getLogin(), republica, false);
                    JOptionPane.showMessageDialog(null, "Sua solicitação foi enviada, aguarde confirmação do representante da republica");
                }
                else{
                    JOptionPane.showMessageDialog(null, "Não há vagas disponíveis");
                }    
            }
            else{
                JOptionPane.showMessageDialog(null, "Nunhuma república selecionada");
            }
        });
    }
    
    private void buscarRepublicas(){
        ArrayList<Map<String, String>> republicas;
        IDAORepublica dao = new RepublicaSQLite();
        republicas = dao.obterRepublicas();
        
        // atualizar a tabela
        for(int i = 0; i < republicas.size(); i++){
            this.view.getjTable1().setValueAt(republicas.get(i).get("nome"), i, 0);
            this.view.getjTable1().setValueAt(republicas.get(i).get("despesasMediasPorMorador"), i, 1);
            this.view.getjTable1().setValueAt(republicas.get(i).get("vagasDisponiveis"), i, 2);
            this.view.getjTable1().setValueAt(republicas.get(i).get("totalDeVagas"), i, 3);
        }
    }
}