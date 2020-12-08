/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import dao.ConvitesSQLite;
import dao.IDAOConvites;
/**
 *
 * @author vitor
 */
public class TestConvites {
    public static void main(String[] args){
        IDAOConvites dao = new ConvitesSQLite();
        dao.adicionarConvite("vitor", "thiago", true);
        dao.aceitarConviteRepublica("vitor", "thiago");
    }
}
