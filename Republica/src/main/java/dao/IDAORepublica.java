/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Republica;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author tabat
 */
public interface IDAORepublica {
   public void addRepublica(Republica republica);
   public ArrayList<Map<String, String>> obterRepublicas();
   public Republica consultarRepublica(String nomeRepublica);
   public void updateRepublica(Republica republica, String nomeAntigo);
   public void excluirRepublica(String nome);
}
