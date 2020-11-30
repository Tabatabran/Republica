/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IDAOUsuario {
   public void addUsuario(String pNome, String pSenha);
   public ArrayList<Usuario> obterUsuarios();
   public boolean consultarLogin(String usuario, String senha);
   public Usuario obterUsuario(Usuario usuario);
   public boolean excluirConta();
}
