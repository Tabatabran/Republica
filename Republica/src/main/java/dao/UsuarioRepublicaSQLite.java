/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.HistoricoRepublica;
import com.pss.model.Usuario;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class UsuarioRepublicaSQLite implements IDAOUsuarioRepublica {

    @Override
    public HistoricoRepublica obterRegistro(String nomeUsuario, String nomeRepublica) {
    HistoricoRepublica registro;
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM usuario_republica WHERE nome_usuario = ? AND nome_republica = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, nomeRepublica);
            resultSet= stmt.executeQuery();
            if(resultSet.next()){
                registro = new HistoricoRepublica(
                        nomeRepublica,
                        LocalDate.parse(resultSet.getString("dataIngresso"), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        LocalDate.parse(resultSet.getString("dataSaida"), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        Double.parseDouble(resultSet.getString("rateio")) 
                );
                return registro;
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
    public ArrayList<HistoricoRepublica> obterRegistro(String nomeUsuario) {
        ArrayList<HistoricoRepublica> registros = new ArrayList<HistoricoRepublica>();
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM usuario_republica WHERE nome_usuario = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, nomeUsuario);
            resultSet= stmt.executeQuery();
            while(resultSet.next()){
                HistoricoRepublica registro;
                LocalDate dataIngresso = (resultSet.getString("dataIngresso") != null) ? LocalDate.parse(resultSet.getString("dataIngresso")) : null;
                LocalDate dataSaida = (resultSet.getString("dataSaida") != null) ? LocalDate.parse(resultSet.getString("dataSaida")) : null; 
                
                registro = new HistoricoRepublica(
                        resultSet.getString("nome_republica"),
                        dataIngresso,
                        dataSaida,
                        resultSet.getDouble("rateio") 
                );
                registros.add(registro);
            }
            return registros;
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
    public boolean salvarRegistro(String nome_usuario, String nome_republica, LocalDate dataIngresso) {
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "INSERT INTO usuario_republica(" +                            
                            "nome_usuario," +
                            "nome_republica," +   
                            "dataIngresso" +
                            ") VALUES(?,?,?)"
                            + ";";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setString(1, nome_usuario);
            preparedStmt.setString(2, nome_republica);
            preparedStmt.setString(3, dataIngresso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                     
            int resultado = preparedStmt.executeUpdate();
            preparedStmt.close();
            
            if(resultado == 1 ){
                //System.out.println("deu bom a inserção");
                return true;
            }else{
                System.out.println("registro nao foi salvo");
                return false;
            }
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
        return false;
    }
    
    
    @Override
    public void updateRegistro(String nome_usuario, String nome_republica, LocalDate dataIngresso, LocalDate dataSaida, Double rateio){
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "UPDATE usuario_republica " +                            
                            "SET dataIgresso = ?, " +
                            "dataSaida = ?, " + 
                            "rateio = ? " + 
                            "WHERE nome_usuario = ? AND nome_republica = ?;";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setString(1, dataIngresso.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setString(2, dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setDouble(3, rateio);
            preparedStmt.setString(4, nome_usuario);
            preparedStmt.setString(5, nome_republica);
                     
            preparedStmt.executeUpdate();
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
    public void updateRegistro(String nome_usuario, String nome_republica, LocalDate dataSaida){
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "UPDATE usuario_republica " +                            
                            "SET dataSaida = ? " + 
                            "WHERE nome_usuario = ? AND nome_republica = ?;";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setString(1, dataSaida.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setString(2, nome_usuario);
            preparedStmt.setString(3, nome_republica);
                     
            preparedStmt.executeUpdate();
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
    public void updateRegistro(String nome_usuario, String nome_republica, Double rateio){
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "UPDATE usuario_republica " +                            
                            "SET rateio = ? " + 
                            "WHERE nome_usuario = ? AND nome_republica = ?;";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setDouble(1, rateio);
            preparedStmt.setString(2, nome_usuario);
            preparedStmt.setString(3, nome_republica);
                     
            preparedStmt.executeUpdate();
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim");
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }
}

