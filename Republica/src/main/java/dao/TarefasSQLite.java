/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public class TarefasSQLite implements IDAOTarefas{

    @Override
    public ArrayList<Tarefa> buscarTarefasDoUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> buscarResponsaveisDaTarefa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void novaTarefa(Tarefa tarefa) {
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
    
   
}
