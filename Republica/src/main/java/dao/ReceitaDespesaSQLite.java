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
            String sqlInsert = "INSERT INTO receitas_despesas("
                    + "republica,"
                    + "tipo,"
                    + "descricao,"
                    + "dataVencimento,"
                    + "dataCadastro,"
                    + "valor,"
                    + "periodicidade"
                    + "valorParcela"
                    + ") VALUES(?,?,?,?,?,?,?,?)"
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, UsuarioLogado.getInstancia().getRepublicaAtual());
            preparedStmt.setString(2, receitaDespesa.getTipo());
            preparedStmt.setString(3, receitaDespesa.getDescricao());
            preparedStmt.setDate(4, Date.valueOf(receitaDespesa.getDataVencimento()));
            preparedStmt.setDate(5, Date.valueOf(receitaDespesa.getDataCadastro()));
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

            String queryID = "SELECT MAX(id_receitas) FROM receitas_despesas";
            stmtID = conexao.criarPreparedStatement(queryID);

            int id = resultSet.getInt("id_receitas");

            for (String nome: receitaDespesa.getMoradoresparticipantes()) {
                conectou = conexao.conectar();
                
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
            System.err.println("sql deu ruim");
        } finally {
            if (conectou) {
                conexao.desconectar();
            }
        }
    }

}
