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
    public ArrayList<Tarefa> buscarTarefasDoUsuario(Usuario usuario);
    public ArrayList<String> buscarResponsaveisDaTarefa(int idTarefas);
    public void novaTarefa(Tarefa tarefa);
    public ArrayList<Tarefa> buscarTarefasPorDescricao(String descricao);
    public void excluirTarefa(int idTarefa);
    public void editarTarefa(Tarefa tarefa);
}
