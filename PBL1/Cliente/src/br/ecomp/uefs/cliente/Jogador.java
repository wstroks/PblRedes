package br.ecomp.uefs.cliente;

import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pagotto
 */
public class Jogador {
    
    
        
    /*
    Adiciona os valores para em uma lista, que é embaralhada e retorna a primeira posição.
    */
    public int valor(){
       
        
        ArrayList<Integer> valores = new ArrayList<Integer>();
        
        valores.add(50);
        valores.add(100);
        valores.add(200);
        valores.add(350);
        valores.add(500);
        valores.add(750);
        valores.add(1000);
        valores.add(50);
        valores.add(350);
        valores.add(200);
        valores.add(1);
        
        Collections.shuffle(valores);

         return valores.get(0);
    }
  
    /*
    Recalcula o valor da pontuação a depender do numero de acertos,
    e retorna o novo valor.
    */    
    public int atualizarResultado(int valor, int acertos, int atual){
        
        return atual+(valor*acertos);
    }
    
    
    
    

}
