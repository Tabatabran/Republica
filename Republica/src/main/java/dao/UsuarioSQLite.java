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
    public void addUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                return true;
            }
                
            /*while (resultSet.next()) {
                System.out.println(resultSet.getString("nome"));
                Funcionario funcionario =  new Funcionario(
                resultSet.getString("nome"),
                resultSet.getString("cargo"),
                resultSet.getDouble("salario_base"));
                funcionario.setID(resultSet.getInt("id"));
                funcionario.setFaltas(resultSet.getInt("faltas"));
                funcionario.setDistancia( resultSet.getDouble("distancia"));
                funcionarios.add(funcionario);
            }*/
            
           
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

    
    
}
