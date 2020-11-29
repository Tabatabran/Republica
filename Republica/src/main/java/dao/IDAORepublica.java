/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Republica;
import java.util.ArrayList;

/**
 *
 * @author tabat
 */
public interface IDAORepublica {
   public void addRepublica(Republica republica);
   public ArrayList<Republica> obterRepublicas();
   public boolean consultarRepublica(String nomeRepublica);
}
