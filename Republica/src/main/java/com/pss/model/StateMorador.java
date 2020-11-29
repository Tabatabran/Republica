/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pss.model;

/**
 *
 * @author Thiago
 */
public abstract class StateMorador {
    private Usuario usuario;

    public StateMorador(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
