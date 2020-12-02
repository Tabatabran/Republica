/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiago
 */
public class ConexaoSQLite {
    private Connection conexao;
    
    public boolean conectar(){
        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\thami\\OneDrive\\banco_de_dados\\banco_sqlite.db";
            this.conexao = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoSQLite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
   
    public boolean desconectar(){
        try{
            if(this.conexao.isClosed()==false){
                this.conexao.close();
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }
    //
    public Statement criarStatement(){
        try{
            return this.conexao.createStatement();
        }catch(SQLException e){
            return null;
        }
    }
    //para executar os sqls
    public PreparedStatement criarPreparedStatement(String sql){
        try{
            return this.conexao.prepareStatement(sql);
        }catch(SQLException e){
            System.out.println("sql qualquer coisa" + e.fillInStackTrace());
            return null;
        }
    }
    public Connection getConexao(){
        return this.conexao;
    }
}
