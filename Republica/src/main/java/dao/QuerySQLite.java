/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor
 */
public class QuerySQLite {
    
    // query sem retorno.
    public void makeQuery(String query){
        System.out.println(query);
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        PreparedStatement stmt = null;
        try{
            conectou=conexao.conectar();
            
            stmt = conexao.criarPreparedStatement(query);
            stmt.executeUpdate();
            stmt.close();
            
        }            
        catch(SQLException e){
            System.err.println("ISQLite: " + e.fillInStackTrace());
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }
    
    public ArrayList<Map<String,String>> makeQueryWReturn(String query, String ... args){
        System.out.println(query);
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        ArrayList<Map<String, String>> resultadoQuery = new ArrayList<>();
        boolean conectou=false;
        Statement stmt = null;
        ResultSet resultSet = null;
        try{
            conectou=conexao.conectar();
            
            stmt = conexao.conexao.createStatement();
            resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                Map<String, String> map = new HashMap<>();
                for(String arg : args){
                    map.put(arg, resultSet.getString(arg));
                }
                resultadoQuery.add(map);
            }
            return resultadoQuery;
        }            
        catch(SQLException e){
            System.err.println("ISQLite: " + e.fillInStackTrace());
            return null;
        }finally{
            try {
                resultSet.close();
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger("MakeQueryWReturn: " + ex.fillInStackTrace());
            }
            if(conectou)
                conexao.desconectar();
        }
    }
}
