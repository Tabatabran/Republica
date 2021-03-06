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
   public Usuario obterUsuario(String nome);
   public String consultarRepublicaDoUsuario(String usuario);
   public ArrayList<Usuario> consultarUsuariosPorRepublica(String nome_republica);
   public boolean excluirConta();
   public boolean adicionarRepulicaDoUsuario(String idRepublica);
   public boolean adicionarRepulicaDoUsuario(String nome_usuario, String idRepublica);
   public boolean alterarPerfilUsuario();
   public void deletarRepublicaAtualDoUsuario(String nomeUsuario);
   public ArrayList<String> obterUsuariosNaRepublicaAtual(String nomeRepublica);
   public ArrayList<Usuario> buscarUsuariosNaRepublicaAtual(String nomeRepublica);
   public ArrayList<Usuario> buscarUsuariosNaRepublicaAtualPorNome(String nomeRepublica, String nome);
   
}
