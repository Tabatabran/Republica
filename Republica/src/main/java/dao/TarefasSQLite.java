/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import com.pss.model.UsuarioLogado;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class TarefasSQLite implements IDAOTarefas{

    @Override
    public ArrayList<Tarefa> buscarTarefasDoUsuario(Usuario usuario) {
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM tarefas WHERE id IN (SELECT id_tarefa FROM tarefas_usuario WHERE nome_usuario = ?);";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1,usuario.getLogin());
            
            
            resultSet= stmt.executeQuery();
            ArrayList<Tarefa> tarefas = new ArrayList<>();
            
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa(resultSet.getDate("data_agendamento").toLocalDate(), null, resultSet.getString("descricao"),resultSet.getDate("data_termino").toLocalDate());
                tarefa.setCodigo(resultSet.getInt("id"));
                tarefas.add(tarefa);
                
            }
                return tarefas;
          
           
        }catch(SQLException e){
            System.err.println("SQL buscar usuarioLogado"+e.fillInStackTrace());
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
    public ArrayList<String> buscarResponsaveisDaTarefa(int idTarefa ) {
           
        ArrayList<String> nomeUsuarios= new ArrayList<>();       
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM tarefas_usuario WHERE id_tarefa = ? ;";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setInt(1, idTarefa);            
            resultSet= stmt.executeQuery();
            
            while(resultSet.next()){
                Usuario usuario= new Usuario();                
                nomeUsuarios.add(resultSet.getString("nome_usuario"));
            }
            
            //return nomesUsuarios;
            return nomeUsuarios;
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


    @Override
    public void novaTarefa(Tarefa tarefa) {
         ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;
              ResultSet resultSet=null;
        try{
            conectou=conexao.conectar();
            String sqlInsert = "INSERT INTO tarefas(" +                            
                            "descricao," +
                            "data_agendamento," +
                            "data_termino"+
                            ") VALUES(?,?,?)"
                            + ";";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, tarefa.getDescricao());            
            
            preparedStmt.setString(2, tarefa.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setString(3, tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            int resultado = preparedStmt.executeUpdate();
            preparedStmt.close();
            
            String sqlBusca = "SELECT id FROM tarefas WHERE id = (SELECT max(id) FROM tarefas);";
            Statement stmt = conexao.criarStatement();
            
            //ResultSet resultSet = stmt.(sqlBusca);
            resultSet=stmt.executeQuery(sqlBusca);
            
            
            if(resultSet.next()){                
             int idTarefa=resultSet.getInt("id");
             stmt.close();
             for(Usuario u:tarefa.getResponsaveis()){
                String sql = "INSERT INTO tarefas_usuario(" +                            
                            "nome_usuario," +
                            "id_tarefa)" +                            
                            "VALUES(?,?)"+
                             ";";
                PreparedStatement stmt2=conexao.criarPreparedStatement(sql);
                stmt2.setString(1,u.getLogin());
                stmt2.setInt(2,idTarefa);
                stmt2.executeUpdate();
             } 
            }
            
           
                     
            
            if(resultado == 1 ){
                JOptionPane.showMessageDialog(null, "Tafera registrada com sucesso!");
            }else{
                System.out.println("tarefa nao inserida");
            }
           
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim"+e.fillInStackTrace()+e.getErrorCode());
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }

    @Override
    public ArrayList<Tarefa> buscarTarefasPorDescricao(String descricao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluirTarefa(int idTarefa) {
       ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        //ResultSet resultSet = null;
        PreparedStatement stmt = null;
        
        try{
            conectou=conexao.conectar();
            
            String query = "DELETE FROM tarefas WHERE id = ?;";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setInt(1,idTarefa);            
            stmt.executeUpdate();
        }catch(SQLException e){
            System.err.println("SQL buscar usuarioLogado"+e.fillInStackTrace());
            
        }finally{
            try{
//                resultSet.close();
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
    public void editarTarefa(Tarefa tarefa) {
         ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;
              ResultSet resultSet=null;
        try{
            conectou=conexao.conectar();
            String sqlInsert = "UPDATE tarefas SET " +                            
                            "descricao = ?," +
                            "data_agendamento = ?," +
                            "data_termino = ?"+
                            " WHERE id = ?"
                            + ";";
            
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, tarefa.getDescricao());           
            preparedStmt.setString(2, tarefa.getDataAgendamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setString(3, tarefa.getDataTermino().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setInt(4, tarefa.getCodigo());
            int resultado = preparedStmt.executeUpdate();
            preparedStmt.close();
            
            
            
            
           
             for(Usuario u:tarefa.getResponsaveis()){
                String sql = "INSERT INTO tarefas_usuario(" +                            
                            "nome_usuario," +
                            "id_tarefa)" +                            
                            "VALUES(?,?)"+
                             ";";
                PreparedStatement stmt2=conexao.criarPreparedStatement(sql);
                stmt2.setString(1,u.getLogin());
                stmt2.setInt(2,tarefa.getCodigo());
                stmt2.executeUpdate();
                
             } 
             ArrayList<String> nomes= buscarResponsaveisDaTarefa(tarefa.getCodigo());
             Usuario usuario = new Usuario();
             for(String nome: nomes){
                 usuario.setLogin(nome);
                 if(!tarefa.getResponsaveis().contains(usuario)){
                     String query = "DELETE FROM tarefas_usuario WHERE nome_usuario = ? and id_tarefa = ?;";
                     PreparedStatement stmt2=conexao.criarPreparedStatement(query);
                     stmt2 = conexao.criarPreparedStatement(query);
                     stmt2.setString(1, UsuarioLogado.getInstancia().getLogin());
                     stmt2.setInt(2, tarefa.getCodigo());
                    stmt2.executeUpdate();

                 }
                     
             }
            
           
                     
            
            if(resultado == 1 ){
                //System.out.println("deu bom a inserção");
            }else{
                System.out.println("pessoa nao inserida");
            }
           
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim"+e.fillInStackTrace()+e.getErrorCode());
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }
    
   
}
