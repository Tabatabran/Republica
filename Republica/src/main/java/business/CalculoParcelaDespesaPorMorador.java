/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import com.pss.model.ReceitaDespesa;

/**
 *
 * @author tabat
 */
public class CalculoParcelaDespesaPorMorador implements ICalculoParcelasDespesa{

    @Override
    public double calcular(ReceitaDespesa receitaDespesa) {
        int numeroMoradores = receitaDespesa.getMoradoresparticipantes().size();
        
        double parcelaPorMorador = receitaDespesa.getValor() / numeroMoradores;
        
        return parcelaPorMorador;
    }
    
}
