/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public interface IDAOConvites {
    public void aceitarConviteRepublica(String convidante, String convidado);
    public void aceitarConviteMorador(String convidante, String convidado);
    public void adicionarConvite(String convidante, String convidado, boolean flag);
    public void removerConvite(String convidante, String convidado, boolean flag);
    public ArrayList<String> consultarConvitesParaRepublica(String nome_representante);
    public ArrayList<String> consultarConvitesParaMorador(String nome_morador);
}

