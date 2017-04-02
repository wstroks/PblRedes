/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.model;

/**
 *
 * @author Pagotto e Ianc
 */
public class Cliente {

  
    private String nome;
    private int pontuacao;
 
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

   

    public void pontuacaoSoma(int soma) {
        pontuacao += soma;
    }

}
