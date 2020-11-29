/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Republica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author tabat
 */
public class RepublicaSQLite implements IDAORepublica{

    @Override
    public void addRepublica(Republica republica) {
        ConexaoSQLite conexao= new ConexaoSQLite();
              boolean conectou = false;        
        try{
            conectou=conexao.conectar();
            String sqlInsert = "INSERT INTO republica(" +                            
                            "nome, " +
                            "dataFundacao, " + 
                            "endereco, " + 
                            "CEP, " + 
                            "bairro, " + 
                            "pontoDeReferencia, " + 
                            "localizacaoGeografica, " + 
                            "codigoDeEtica, " + 
                            "vantagens, " + 
                            "despesasMediasPorMorador, " + 
                            "totalDeVagas, " + 
                            "vagasDisponiveis, " + 
                            "vagasOcupadas" + 
                            ") VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"
                            + ";";
            
            PreparedStatement preparedStmt = conexao.criarPreparedStatement(sqlInsert);            
            preparedStmt.setString(1, republica.getNome());
            preparedStmt.setDate(2, Date.valueOf(republica.getDataFundacao()));
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
            if(resultado == 1 ){
                JOptionPane.showMessageDialog(null, "República cadastrada com sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "República não inserida");
            }
           
            preparedStmt.close();
        }            
        catch(SQLException e){
            System.err.println("sql deu ruim"+e.fillInStackTrace());
        }finally{
            if(conectou)
                conexao.desconectar();
        }
    }

    @Override
    public ArrayList<Republica> obterRepublicas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean consultarRepublica(String nomeRepublica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
