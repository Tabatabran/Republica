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
            if(resultSet.next()){
                return true;
            }
                
            else{
                return false;
            }
                
          
           
        }catch(SQLException e){
            System.err.println("SQL buscar funcionario");
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

    
    
}
