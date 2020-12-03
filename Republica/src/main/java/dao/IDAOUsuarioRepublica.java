/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.HistoricoRepublica;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public interface IDAOUsuarioRepublica {
    public HistoricoRepublica obterRegistro(String nomeUsuario, String nomeRepublica);
    public ArrayList<HistoricoRepublica> obterRegistro(String nomeUsuario); // puxa o historico de republica do usuario.
    public boolean salvarRegistro(String nome_usuatio, String nome_republica, LocalDate dataIngresso);
    public void updateRegistro(String nome_usuario, String nome_republica, LocalDate dataIngresso, LocalDate dataSaida, Double rateio);
}
