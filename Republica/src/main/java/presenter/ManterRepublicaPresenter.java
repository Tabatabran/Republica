/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presenter;

import com.pss.model.Republica;
import com.pss.model.UsuarioLogado;
import dao.IDAORepublica;
import dao.IDAOUsuario;
import dao.RepublicaSQLite;
import dao.UsuarioSQLite;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import presenter.ManterMoradorPresenter;
import view.ManterRepublicaView;

/**
 *
 * @author tabat
 */
public class ManterRepublicaPresenter {

    private ManterRepublicaView view;

    public ManterRepublicaPresenter() {

        if (UsuarioLogado.getInstancia().getRepublicaAtual() == null) {
            JOptionPane.showMessageDialog(null, "Você não está em nunhuma república");
        } else {
            this.view = new ManterRepublicaView();
            this.view.setLocationRelativeTo(null);
            this.view.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

            configurarView();
            botaoEditar();
            botaoManterMoradores();
            botaoExcluirRepublica();
            preencherVagasDisponiveis();

            this.view.setVisible(true);
        }
    }

    public void configurarView() {
        IDAORepublica dao = new RepublicaSQLite();
        Republica republica = dao.consultarRepublica(UsuarioLogado.getInstancia().getRepublicaAtual());

        view.getjTextBairro().setText(republica.getBairro());
        view.getjTextCEP().setText(republica.getCEP());
        view.getjTextCodigoDeEtica().setText(republica.getCodigoDeEtica());
        view.getjTextDataDaFundacao().setText(String.valueOf(republica.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        view.getjTextDespesasMediasPorMorador().setText(String.valueOf(republica.getDespesasMediasPorMorador()));
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
                String nomeAntigo = UsuarioLogado.getInstancia().getRepublicaAtual();
                if (Integer.parseInt(view.getjTextVagasOcupadas().getText()) > Integer.parseInt(view.getjTextTotalDeVagas().getText())) {
                    JOptionPane.showMessageDialog(null, "Número de vagas ocupadas superior ao total!");
                } else if (view.getjTextNome().getText().isEmpty() || view.getjTextDataDaFundacao().getText().isEmpty() || view.getjTextLogradouro().getText().isEmpty() || view.getjTextCEP().getText().isEmpty() || view.getjTextBairro().getText().isEmpty() || view.getjTextVantagens().getText().isEmpty() || view.getjTextDespesasMediasPorMorador().getText().isEmpty() || view.getjTextTotalDeVagas().getText().isEmpty() || view.getjTextVagasOcupadas().getText().isEmpty() || view.getjTextVagasDisponiveis().getText().isEmpty() || view.getjTextPontoDeReferencia().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios!");
                } else {
                    Republica republica = new Republica(
                            view.getjTextNome().getText(),
                            LocalDate.parse(view.getjTextDataDaFundacao().getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                            view.getjTextLogradouro().getText(),
                            view.getjTextCEP().getText(),
                            view.getjTextBairro().getText(),
                            view.getjTextVantagens().getText(),
                            Double.parseDouble(view.getjTextDespesasMediasPorMorador().getText()),
                            Integer.parseInt(view.getjTextTotalDeVagas().getText()),
                            Integer.parseInt(view.getjTextVagasOcupadas().getText()),
                            Integer.parseInt(view.getjTextVagasDisponiveis().getText()),
                            view.getjTextPontoDeReferencia().getText());

                    republica.setCodigoDeEtica(view.getjTextCodigoDeEtica().getText());
                    republica.setLocalizacaoGeografica(view.getjTextLocalizacaoGeografica().getText());

                    IDAORepublica dao = new RepublicaSQLite();

                    dao.updateRepublica(republica, nomeAntigo);

                    if (nomeAntigo != view.getjTextNome().getText()) {
                        UsuarioLogado.getInstancia().setRepublicaAtual(view.getjTextNome().getText());
                    }
                    
                    view.dispose();
                }

            }
        });
    }

    public void botaoManterMoradores() {
        this.view.getjButtonManterMoradores().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManterMoradorPresenter();
            }
        });

    }

    public void botaoExcluirRepublica() {
        this.view.getjButtonExcluirRepublica().addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja excluir a república?", "Aviso",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    String nomeRepublica = UsuarioLogado.getInstancia().getRepublicaAtual();

                    IDAORepublica dao = new RepublicaSQLite();
                    dao.excluirRepublica(nomeRepublica);

                    UsuarioLogado.getInstancia().setRepublicaAtual(null);

                    IDAOUsuario daoUsuario = new UsuarioSQLite();
                    daoUsuario.deletarRepublicaAtualDoUsuario(UsuarioLogado.getInstancia().getLogin());
                    
                    view.dispose();

                }
            }
        });

    }
    
    public void preencherVagasDisponiveis() {
        this.view.getjTextVagasOcupadas().addKeyListener(new java.awt.event.KeyListener() {
            public void keyTyped(java.awt.event.KeyEvent e) {   
            }

            public void keyPressed(java.awt.event.KeyEvent e) {
            }

            public void keyReleased(java.awt.event.KeyEvent e) {
                
                int valor = Integer.valueOf(view.getjTextTotalDeVagas().getText()) - Integer.valueOf(view.getjTextVagasOcupadas().getText());

                view.getjTextVagasDisponiveis().setText(String.valueOf(valor));
                
            }
        });
    }

}
