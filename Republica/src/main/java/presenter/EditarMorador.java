/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.UsuarioLogado;
import dao.IDAOUsuarioRepublica;
import dao.UsuarioRepublicaSQLite;

/**
 *
 * @author vitor
 */
public class EditarMorador {
    private view.EditarMorador view;
    private String nome_usuario;
    
    public EditarMorador(String nome_usuario){
        this.nome_usuario = nome_usuario;
        this.view = new view.EditarMorador();
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.view.setLocationRelativeTo(null);
        this.view.getjLabel1().setText(nome_usuario);
        salvar();
        this.view.setVisible(true);
    }
    
    public void salvar(){
        this.view.getjButtonSalvar().addActionListener((e) -> {
            double rateio = Double.parseDouble(this.view.getjTextFieldRateio().getText());
            // atualizar o banco de dados
            IDAOUsuarioRepublica dao = new UsuarioRepublicaSQLite();
            dao.updateRegistro(this.nome_usuario, UsuarioLogado.getInstancia().getRepublicaAtual(), rateio);
        });
    }
    
    public void cancelar(){
        
    }
}
