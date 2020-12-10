/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.ReceitaDespesa;
import com.pss.model.UsuarioLogado;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tabat
 */
public class ReceitaDespesaSQLite implements IDAOReceitaDespesa {

    @Override
    public void cadastrarReceitaDespesa(ReceitaDespesa receitaDespesa) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;

        try {
            conectou = conexao.conectar();
            String sqlInsert = "INSERT INTO receitas_Despesas("
                    + "republica,"
                    + "tipo,"
                    + "descricao,"
                    + "dataVencimento,"
                    + "dataCadastro,"
                    + "valor,"
                    + "periodicidade,"
                    + "valorParcela"
                    + ") VALUES(?,?,?,?,?,?,?,?)"
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, UsuarioLogado.getInstancia().getRepublicaAtual());
            preparedStmt.setString(2, receitaDespesa.getTipo());
            preparedStmt.setString(3, receitaDespesa.getDescricao());
            preparedStmt.setString(4, receitaDespesa.getDataVencimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));            
            preparedStmt.setString(5, receitaDespesa.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setDouble(6, receitaDespesa.getValor());
            preparedStmt.setString(7, receitaDespesa.getPeriodicidade());
            preparedStmt.setDouble(8, receitaDespesa.getValorParcela());

            int resultado = preparedStmt.executeUpdate();
            
            cadastrarListaDeMoradoresParticipantes(receitaDespesa);
            
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "Receita / Despesa cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Receita / Despesa não cadastrada!");
            }

            preparedStmt.close();
        } catch (SQLException e) {
            System.err.println("sql deu ruim");
        } finally {
            if (conectou) {
                conexao.desconectar();
            }
        }
    }

    @Override
    public void cadastrarListaDeMoradoresParticipantes(ReceitaDespesa receitaDespesa) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;

        try {

            ResultSet resultSet = null;
            PreparedStatement stmtID = null;
            conectou = conexao.conectar();

            String queryID = "SELECT MAX(id_receitas) AS id FROM receitas_Despesas";
            stmtID = conexao.criarPreparedStatement(queryID);
            
            resultSet = stmtID.executeQuery();

            int id = resultSet.getInt("id");
            
            System.out.println(id);

            for (String nome: receitaDespesa.getMoradoresparticipantes()){
                
                String sqlInsert = "INSERT INTO receitas_despesas_usuarios_participantes("
                        + "id_receitas,"
                        + "nome_usuario"
                        + ") VALUES(?,?)"
                        + ";";

                PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
                preparedStmt.setInt(1, id);
                preparedStmt.setString(2, nome);

                int resultado = preparedStmt.executeUpdate();
                if (resultado == 1) {
                    System.out.println("ok");;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar morador");
                }

                preparedStmt.close();
            }
        } catch (SQLException e) {
            System.err.println("sql deu ruim nos moradores participantes" + e.fillInStackTrace());
        } finally {
            if (conectou) {
                conexao.desconectar();
            }
        }
    }
    
    public ArrayList<ReceitaDespesa> buscarReceitasDespesas(String nomeRepublica){
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT * FROM receitas_despesas "
                    + "WHERE republica = ?;";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1,nomeRepublica);
            
            
            resultSet= stmt.executeQuery();
            ArrayList<ReceitaDespesa> recitasDespesas = new ArrayList<>();
            
            while(resultSet.next()){       
                
                ReceitaDespesa receitaDespesa = new ReceitaDespesa(resultSet.getString("tipo"),
                    resultSet.getString("descricao"),
                    LocalDate.parse(resultSet.getString("dataCadastro"), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                    resultSet.getDouble("valor"),
                    resultSet.getString("periodicidade"),
                    buscarMoradoresResponsaveisPorReceitaDespesa(resultSet.getInt("id_receitas")));
                
                receitaDespesa.setDataVencimento(LocalDate.parse(resultSet.getString("dataVencimento"), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                receitaDespesa.setValorParcela(resultSet.getDouble("valorParcela"));
                receitaDespesa.setCodigo(resultSet.getInt("id_receitas"));
            }
                return recitasDespesas;
          
           
        }catch(SQLException e){
            System.err.println("SQL " + e.fillInStackTrace());
            return null;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("SQL " + e.fillInStackTrace()); 
            }
            if(conectou){
                conexao.desconectar();
                System.out.println("fechou a conexao");
            }
        }
    }
    
    public ArrayList<String> buscarMoradoresResponsaveisPorReceitaDespesa(int idReceitaDespesa){
        ConexaoSQLite conexao= new ConexaoSQLite();
          
        boolean conectou=false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        
        try{
            conectou=conexao.conectar();
            
            String query = "SELECT nome_usuario FROM receitas_despesas_usuarios_participantes "
                    + "WHERE id_receitas = ?;";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setInt(1,idReceitaDespesa);
            
            
            resultSet= stmt.executeQuery();
            ArrayList<String> usuariosParticipantes = new ArrayList<>();
            
            while(resultSet.next()){
                
                usuariosParticipantes.add(resultSet.getString("nome_usuario"));
 
            }
                return usuariosParticipantes;
          
           
        }catch(SQLException e){
            System.err.println("SQL " + e .fillInStackTrace());
            return null;
        }finally{
            try{
                resultSet.close();
                stmt.close();
            }catch(SQLException e){
                System.out.println("sql falha " + e.fillInStackTrace()); 
            }
            if(conectou){
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
    }

}
