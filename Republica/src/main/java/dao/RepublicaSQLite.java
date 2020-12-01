package dao;

import com.pss.model.Republica;
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
public class RepublicaSQLite implements IDAORepublica {

    @Override
    public void addRepublica(Republica republica) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;
        try {
            conectou = conexao.conectar();
            String sqlInsert = "INSERT INTO republica("
                    + "nome, "
                    + "dataFundacao, "
                    + "endereco, "
                    + "CEP, "
                    + "bairro, "
                    + "pontoDeReferencia, "
                    + "localizacaoGeografica, "
                    + "codigoDeEtica, "
                    + "vantagens, "
                    + "despesasMediasPorMorador, "
                    + "totalDeVagas, "
                    + "vagasDisponiveis, "
                    + "vagasOcupadas"
                    + ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, republica.getNome());
            preparedStmt.setString(2, republica.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            preparedStmt.setString(3, republica.getEndereco());
            preparedStmt.setString(4, republica.getCEP());
            preparedStmt.setString(5, republica.getBairro());
            preparedStmt.setString(6, republica.getPondeDeReferencia());
            preparedStmt.setString(7, republica.getLocalizacaoGeografica());
            preparedStmt.setString(8, republica.getCodigoDeEtica());
            preparedStmt.setString(9, republica.getVantagens());
            preparedStmt.setDouble(10, republica.getDespesasMediasPorMorador());
            preparedStmt.setInt(11, republica.getTotalDeVagas());
            preparedStmt.setInt(12, republica.getVagasDisponiveis());
            preparedStmt.setInt(13, republica.getVagasOcupadas());

            int resultado = preparedStmt.executeUpdate();
            if (resultado == 1) {
                JOptionPane.showMessageDialog(null, "República cadastrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "República não inserida");
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
    public ArrayList<Republica> obterRepublicas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Republica consultarRepublica(String nomeRepublica) {
        ConexaoSQLite conexao = new ConexaoSQLite();

        boolean conectou = false;
        ResultSet resultSet = null;
        PreparedStatement stmt = null;
        //ArrayList<Funcionario> funcionarios = new ArrayList<>();
        try {
            conectou = conexao.conectar();

            String query = "SELECT * FROM republica WHERE nome = ?";
            stmt = conexao.criarPreparedStatement(query);
            stmt.setString(1, nomeRepublica);
            resultSet = stmt.executeQuery();
            //nome, dataFundacao, endereco, CEP, bairro, pontoDeReferencia, localizacaoGeografica, codigoDeEtica, vantagens, despesasMediasPorMorador, totalDeVagas, vagasDisponiveis, vagasOcupadas
            // Republica(String nome, LocalDate dataFundacao, String endereco, String CEP, String bairro, String vantagens, double despesasMediasPorMorador, int totalDeVagas, int vagasOcupadas, int vagasDisponiveis, String referencia)
            if (resultSet.next()) {
                Republica republica = new Republica(
                        resultSet.getString("nome"),
                        LocalDate.parse(resultSet.getString("dataFundacao"), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                        resultSet.getString("endereco"),
                        resultSet.getString("CEP"),
                        resultSet.getString("bairro"),
                        resultSet.getString("vantagens"),
                        resultSet.getDouble("despesasMediasPorMorador"),
                        Integer.parseInt(resultSet.getString("totalDeVagas")),
                        Integer.parseInt(resultSet.getString("vagasOcupadas")),
                        Integer.parseInt(resultSet.getString("vagasDisponiveis")),
                        resultSet.getString("pontoDeReferencia"));
                republica.setCodigoDeEtica(resultSet.getString("codigoDeEtica"));
                republica.setLocalizacaoGeografica(resultSet.getString("localizacaoGeografica"));

                return republica;

            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                resultSet.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println("dao.FuncionarioDAO.buscarFuncionario() reulset...");
            }
            if (conectou) {
                conexao.desconectar();
                //System.out.println("fechou a conexao");
            }
        }
    }

    @Override
    public void updateRepublica(Republica republica, String nomeAntigo) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;
        try {
            conectou = conexao.conectar();
            String sqlInsert = "UPDATE republica SET "
                    + "nome = ?"  
                    + ",dataFundacao = ?" 
                    + ",endereco = ?" 
                    + ",CEP = ?" 
                    + ",bairro = ?" 
                    + ",pontoDeReferencia = ?" 
                    + ",localizacaoGeografica = ?" 
                    + ",codigoDeEtica = ?" 
                    + ",vantagens = ?" 
                    + ",despesasMediasPorMorador = ?" 
                    + ",totalDeVagas = ?" 
                    + ",vagasDisponiveis = ?" 
                    + ",vagasOcupadas = ?" 
                    + " WHERE nome = ?" 
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, republica.getNome());
            preparedStmt.setString(2, republica.getDataFundacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
            preparedStmt.setString(3, republica.getEndereco());
            preparedStmt.setString(4, republica.getCEP());
            preparedStmt.setString(5, republica.getBairro());
            preparedStmt.setString(6, republica.getPondeDeReferencia());
            preparedStmt.setString(7, republica.getLocalizacaoGeografica());
            preparedStmt.setString(8, republica.getCodigoDeEtica());
            preparedStmt.setString(9, republica.getVantagens());
            preparedStmt.setDouble(10, republica.getDespesasMediasPorMorador());
            preparedStmt.setInt(11, republica.getTotalDeVagas());
            preparedStmt.setInt(12, republica.getVagasDisponiveis());
            preparedStmt.setInt(13, republica.getVagasOcupadas());
            preparedStmt.setString(14, nomeAntigo);

            try {
                int resultado = preparedStmt.executeUpdate();
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, "República atualizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "República não atualizada");
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
    public void excluirRepublica(String nomeRepublica) {
        ConexaoSQLite conexao = new ConexaoSQLite();
        boolean conectou = false;
        try {
            conectou = conexao.conectar();
            String sqlInsert = "DELETE FROM republica" 
                    + " WHERE nome = ?" 
                    + ";";

            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);
            preparedStmt.setString(1, nomeRepublica);
            

            try {
                int resultado = preparedStmt.executeUpdate();
                if (resultado == 1) {
                    JOptionPane.showMessageDialog(null, "República deletada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "República não deletada");
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

}
