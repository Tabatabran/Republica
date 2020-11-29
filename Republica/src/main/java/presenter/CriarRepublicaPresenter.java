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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import view.CriarRepublicaView;

/**
 *
 * @author tabat
 */
public class CriarRepublicaPresenter {
    private CriarRepublicaView view;

    public CriarRepublicaPresenter(){
        this.view = new CriarRepublicaView();
        botaoConfirmar();
        this.view.setVisible(true);
    }
    
    public void botaoConfirmar(){
        this.view.getjButtonConfirmar().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(view.getjTextDataFundacao().getText(), formatter);
                
                if(Integer.parseInt(view.getjTextVagasOcupadas().getText()) > Integer.parseInt(view.getjTextTotalVagas().getText())){
                    JOptionPane.showMessageDialog(null,"Número de vagas ocupadas superior ao total!");
                }else if(view.getjTextNome().getText().isEmpty() || view.getjTextDataFundacao().getText().isEmpty() ||view.getjTextLogradouro().getText().isEmpty() || view.getjTextCEP().getText().isEmpty() || view.getjTextBairro().getText().isEmpty() || view.getjTextVantagens().getText().isEmpty() || view.getjTextDespesasMediasMorador().getText().isEmpty() || view.getjTextTotalVagas().getText().isEmpty() || view.getjTextVagasOcupadas().getText().isEmpty() || view.getjTextVagasDisponiveis().getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Preencha os campos obrigatórios!");
                }else{
                    Republica republica = new Republica(view.getjTextNome().getText(), data, view.getjTextLogradouro().getText(), view.getjTextCEP().getText(), view.getjTextBairro().getText(), view.getjTextVantagens().getText(), Double.parseDouble(view.getjTextDespesasMediasMorador().getText()), Integer.parseInt(view.getjTextTotalVagas().getText()), Integer.parseInt(view.getjTextVagasOcupadas().getText()),Integer.parseInt(view.getjTextVagasDisponiveis().getText()));
                
                    republica.setCodigoDeEtica(view.getjTextCodigoEtica().getText());
                    republica.setLocalizacaoGeografica(view.getjTextLocalizacaoGeografica().getText());
                    
                    IDAORepublica dao = new RepublicaSQLite();
                    dao.addRepublica(republica);
                }
                
                
            }
        });
    }
    
    
    
    
}
