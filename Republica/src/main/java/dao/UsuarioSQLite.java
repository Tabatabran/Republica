/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.pss.model.UsuarioLogado;
import com.pss.model.Republica;


/**
 *
 * @author Thiago
 */
public class UsuarioSQLite implements IDAOUsuario{

    @Override
    public void addUsuario(String pNome, String pSenha) {
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "INSERT INTO usuarios(" +                            
                            "nome_usuario," +
                            "senha" +                       
                            ") VALUES(?,?)"
                            + ";";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setString(1, pNome);
            preparedStmt.setString(2, pSenha);
                     
            int resultado = preparedStmt.executeUpdate();
            if(resultado == 1 ){
                //System.out.println("deu bom a inserção");
            }else{
                System.out.println("pessoa nao inserida");
            }
           
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }

    @Override
    public ArrayList<Usuario> obterUsuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean consultarLogin(String usuario, String senha) {
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            resultSet= stmt.executeQuery();
            //login, senha, nome, apelido, cpf, redeSocial, telefone1, telefone2,  telefone3
            if(resultSet.next()){
                UsuarioLogado.getInstancia(resultSet.getString("nome_usuario"),
                         resultSet.getString("senha"),
                         resultSet.getString("nome"),
                         resultSet.getString("apelido"), 
                         resultSet.getString("cpf"), 
                         resultSet.getString("rede_social"), 
                         resultSet.getString("telefone1"), 
                         resultSet.getString("telefone2"),
                         resultSet.getString("telefone3"),
                         resultSet.getString("republica"),
                         resultSet.getBoolean("visibilidade"));
                         
                return true;
            }
            else{
                return false;
            }
                
          
           
        }catch(SQLException e){
            System.err.println("SQL buscar usuarioLogado"+e.fillInStackTrace());
            return false;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("dao.FuncionarioDAO.buscarFuncionario() reulset..."); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
    
    }

    @Override
    public Usuario obterUsuario(Usuario usuarioP) {
        Usuario usuario;
         ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM usuarios WHERE nome_usuario = ? AND senha = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, usuarioP.getLogin());
            stmt.setString(2, usuarioP.getSenha());
            resultSet= stmt.executeQuery();
            if(resultSet.next()){
                usuarioP.setNome( resultSet.getString("nome_usuario"));
                usuarioP.setApelido( resultSet.getString("apelido"));
                usuarioP.setCPF( resultSet.getString("cpf"));
                usuarioP.setLinkRedeSocial( resultSet.getString("rede_social"));
                usuarioP.setTelefone1( resultSet.getString("telefone1"));
                usuarioP.setTelefone2( resultSet.getString("telefone2"));
                usuarioP.setTelefone3( resultSet.getString("telefone3"));
                return usuarioP;
            }
                
            else{
                return null;
            }
                
          
           
        }catch(SQLException e){
            System.err.println("SQL buscar funcionario");
            return null;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("dao.FuncionarioDAO.buscarFuncionario() reulset..."); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
        
    }
    @Override
    public boolean excluirConta(){
        
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "DELETE FROM usuarios WHERE nome_usuario = ? ";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, UsuarioLogado.getInstancia().getLogin());
            
             
            stmt.executeUpdate();
       
        }catch(SQLException e){
            System.err.println("SQL buscar funcionario"+e.fillInStackTrace());
            return false;
        }finally{
            try{
               
                stmt.close();
            }catch(SQLException e){
                System.out.println("dao.FuncionarioDAO.buscarFuncionario() reulset..."); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
        return true;
    }
    
    @Override
    public ArrayList<Usuario> consultarUsuariosPorRepublica(String nome_republica){
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM usuarios WHERE republica = ? ";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, nome_republica);
            resultSet= stmt.executeQuery();
            while(resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setNome( resultSet.getString("nome_usuario"));
                usuario.setApelido( resultSet.getString("apelido"));
                usuario.setCPF( resultSet.getString("cpf"));
                usuario.setLinkRedeSocial( resultSet.getString("rede_social"));
                usuario.setTelefone1( resultSet.getString("telefone1"));
                usuario.setTelefone2( resultSet.getString("telefone2"));
                usuario.setTelefone3( resultSet.getString("telefone3"));
                
                usuarios.add(usuario);
            }
            return usuarios;
        }catch(SQLException e){
            System.err.println("SQL buscar funcionario");
            return null;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("dao.FuncionarioDAO.buscarFuncionario() reulset..."); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
    }
    
    @Override
    public boolean adicionarRepulicaDoUsuario(String idRepublica){
        ConexaoSQLite conexao= new ConexaoSQLite();
        boolean conectou = false;        
        try{
            
            conectou=conexao.conectar();            
            String sqlUpdate = "UPDATE usuarios SET republica = ? WHERE nome_usuario = ?";             
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlUpdate);
            if(preparedStmt==null){
                System.out.println("nao criou o stmt");
            }
            //System.out.println(pNome);
            preparedStmt.setString(1,idRepublica );
            
            preparedStmt.setString(2, UsuarioLogado.getInstancia().getLogin());            
            UsuarioLogado.getInstancia().setRepublicaAtual(idRepublica);
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            
            
            
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
        return true;
    }
    
    @Override
    public boolean adicionarRepulicaDoUsuario(String nome_usuario, String idRepublica){
        ConexaoSQLite conexao= new ConexaoSQLite();
        boolean conectou = false;        
        try{
            
            conectou=conexao.conectar();            
            String sqlUpdate = "UPDATE usuarios SET republica = ? WHERE nome_usuario = ?";             
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlUpdate);
            if(preparedStmt==null){
                System.out.println("nao criou o stmt");
            }
            preparedStmt.setString(1,idRepublica );
            preparedStmt.setString(2, nome_usuario);            
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
        return true;
    }
    
    @Override
    public boolean alterarPerfilUsuario(){
         ConexaoSQLite conexao= new ConexaoSQLite();
        boolean conectou = false;        
        try{              
            conectou=conexao.conectar();            
            String sqlUpdate = "UPDATE usuarios SET nome = ?, apelido = ?, rede_social=?, "
                    + " telefone1 = ?, telefone2 = ?, telefone3 = ?, visibilidade = ? WHERE nome_usuario = ?";             
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlUpdate);
            if(preparedStmt==null){
                System.out.println("nao criou o stmt");
            }
         
            preparedStmt.setString(1,UsuarioLogado.getInstancia().getNome() );
            preparedStmt.setString(2,UsuarioLogado.getInstancia().getApelido());                
            preparedStmt.setString(3,UsuarioLogado.getInstancia().getLinkRedeSocial());
            preparedStmt.setString(4,UsuarioLogado.getInstancia().getTelefone1());
            preparedStmt.setString(5,UsuarioLogado.getInstancia().getTelefone2());
            preparedStmt.setString(6,UsuarioLogado.getInstancia().getTelefone3());
            preparedStmt.setBoolean(7,UsuarioLogado.getInstancia().isPerfil());
            preparedStmt.setString(8, UsuarioLogado.getInstancia().getLogin());            
            
            
            preparedStmt.executeUpdate();
            preparedStmt.close();
            
            
            
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
        return true;
    }

    @Override
    public void deletarRepublicaAtualDoUsuario(String nomeUsuario) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;
        try {
            conectou = conexao.conectar();
            String sqlInsert = "UPDATE usuarios SET "
                    + "republica = ?"  
                    + " WHERE nome_usuario = ?" 
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, null);
            preparedStmt.setString(2, nomeUsuario);

            try {
                int resultado = preparedStmt.executeUpdate();
                if (resultado == 1) {
                    System.out.println("ok");
                } else {
                    System.out.println("erro ao deletar republica atual do usuario");
                }
            } catch (SQLException e) {
                System.err.println("sql " + e.fillInStackTrace());
            }

            preparedStmt.close();
        } catch (SQLException e) {
            System.err.println("sql deu ruim" + e.fillInStackTrace());
        } finally {
            if (conectou) {
                conexao.desconectar();
            }
        }
    }
    
    
    @Override
    public String[] obterUsuariosNaRepublicaAtual(String nomeRepublica) {
        String[] nomesUsuarios = new String[30];
        int i = 1;
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT nome FROM usuarios WHERE republica = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, nomeRepublica);
            resultSet= stmt.executeQuery();
            
            while(resultSet.next()){
                nomesUsuarios[i] = resultSet.getString("nome");
                i += 1;
            }
            
            return nomesUsuarios;
            
        }catch(SQLException e){
            System.err.println("SQL buscar funcionario");
            return null;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("sql erro"); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
    }
    
}
