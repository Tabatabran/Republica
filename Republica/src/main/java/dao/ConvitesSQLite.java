/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  
 * @author vitor
 */
public class ConvitesSQLite extends QuerySQLite implements IDAOConvites  {
    private String tabela;
    private String convidante;
    private String convidado;

    private void flag(boolean flag){
     this.tabela = flag ? "convites_republica_para_morador" : "convites_morador_para_republica"; 
     this.convidante = flag ? "republica" : "morador";
     this.convidado = flag ? "morador" : "republica";
    }
    /**
     * Adiciona o convite ao banco de dados na devida tabela 'convites_republica_para_morador'
     * ou 'convites_morador_para_republica' de acordo com 'flag'.
     * 
     * @param convidante
     * @param convidado
     * @param flag deve ser 'true' se o convite for de republica para morador, 'false' caso contrario.
     */
    @Override
    public void adicionarConvite(String convidante, String convidado, boolean flag) {
        this.flag(flag);
        this.makeQuery(String.format("INSERT INTO %s (%s, %s) VALUES (\"%s\", \"%s\");", 
                this.tabela, this.convidante, this.convidado, convidante, convidado));
    }

    @Override
    public void removerConvite(String convidante, String convidado, boolean flag) {
        this.flag(flag);
        this.makeQuery(String.format("DELETE FROM %s WHERE %s = \"%s\" AND %s = \"%s\";", 
                this.tabela, this.convidante, convidante, this.convidado, convidado));
    }
    
    /**
     * Convite de representante de republica para morador.
     * 
     * @param republica
     * @param convidado
     */
    @Override
    public void aceitarConviteRepublica(String republica, String convidado) {
        IDAOUsuario dao = new UsuarioSQLite();
        // inserir o convidado na republica
        dao.adicionarRepulicaDoUsuario(convidado, republica);
        this.removerConvite(republica, convidado, true);
    }

    /**
     * Convite de morador para representante de republica. insere o convidante na republica
     * do convidado e deleta o convite.
     * 
     * @param morador
     * @param republica
     */
    @Override
    public void aceitarConviteMorador(String morador, String republica) {
        IDAOUsuario dao = new UsuarioSQLite();
        // inserir o convidante na republica
        dao.adicionarRepulicaDoUsuario(morador, republica);
        this.removerConvite(morador, republica, false);
    }

    /**
     *
     * @param republica 
     * @return retorna a lista de todos os usuarios que solicitaram participar da republica
     * do representante.
     */
    @Override
    public ArrayList<String> consultarConvitesParaRepublica(String republica) {
        ArrayList<Map<String, String>> queryResult;
        ArrayList<String> convites = new ArrayList<String>();
        // convites de morador para representante
        this.flag(false);
        
        queryResult = this.makeQueryWReturn(String.format("SELECT morador FROM %s WHERE republica = \"%s\";",
                this.tabela, republica), "morador");
        
        queryResult.forEach((a) -> {
            convites.add(a.get("morador"));
        });
        return convites;
    }

    @Override
    public ArrayList<String> consultarConvitesParaMorador(String nome_morador) {
        ArrayList<Map<String, String>> queryResult;
        ArrayList<String> convites = new ArrayList<String>();
        // convites de representante para morador
        this.flag(true);
        
        queryResult = this.makeQueryWReturn(String.format("SELECT republica FROM %s WHERE morador = \"%s\";",
                this.tabela, nome_morador), "republica");
        
        queryResult.forEach((a) -> {
            convites.add(a.get("republica"));
        });
        return convites;
    }
}
