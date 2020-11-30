/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.Republica;
import dao.IDAORepublica;
import dao.RepublicaSQLite;
import java.awt.event.ActionEvent;
import view.ManterRepublicaView;

/**
 *
 * @author tabat
 */
public class ManterRepublicaPresenter {
    private ManterRepublicaView view;
    private Republica republica;

    public ManterRepublicaPresenter() {
        this.view = new ManterRepublicaView();
        this.view.setLocationRelativeTo(null);
        this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        botaoEditar();
        
        this.view.setVisible(true);
    }
    
    //colocar esse configura view depois que resolver o problema de state
    public void configurarView(){
        IDAORepublica dao = new RepublicaSQLite();
        this.republica = dao.consultarRepublica("Colocar aqui o nome do usuário ou da republica");
        
        view.getjTextBairro().setText(republica.getBairro());
        view.getjTextCEP().setText(republica.getCEP());
        view.getjTextCodigoDeEtica().setText(republica.getCodigoDeEtica());
        view.getjTextDataDaFundacao().setText(String.valueOf(republica.getDataFundacao()));
        view.getjTextDespesasMediasPorMorador().setText(String.valueOf(republica.getDespesasMediasPorMorador()).replaceAll(".", ","));
        view.getjTextLocalizacaoGeografica().setText(republica.getLocalizacaoGeografica());
        view.getjTextLogradouro().setText(republica.getEndereco());
        view.getjTextNome().setText(republica.getNome());
        view.getjTextPontoDeReferencia().setText(republica.getPondeDeReferencia());
        view.getjTextTotalDeVagas().setText(String.valueOf(republica.getTotalDeVagas()));
        view.getjTextVagasDisponiveis().setText(String.valueOf(republica.getVagasDisponiveis()));
        view.getjTextVagasOcupadas().setText(String.valueOf(republica.getVagasOcupadas()));
        view.getjTextVantagens().setText(republica.getVantagens());
    }
    
    public void botaoEditar() {
        this.view.getjButtonEditar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                
                

            }
        });
    }
    
    
}
