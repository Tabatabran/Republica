/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.pss.model.Tarefa;
import com.pss.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Thiago
 */
public interface IDAOTarefas {
    public ArrayList<Tarefa> buscarTarefasDoUsuario();
    public ArrayList<Usuario> buscarResponsaveisDaTarefa();
    public void novaTarefa(Tarefa tarefa);
}
