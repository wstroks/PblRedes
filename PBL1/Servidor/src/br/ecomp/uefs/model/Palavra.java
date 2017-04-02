/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.model;

/**
 *
 * @author Pagotto
 */
public class Palavra {
    private String Palavra;
    private String Tema;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPalavra(String Palavra) {
        this.Palavra = Palavra;
    }

    public void setTema(String Tema) {
        this.Tema = Tema;
    }

    public String getPalavra() {
        return Palavra;
    }

    public String getTema() {
        return Tema;
    }

    
    
    
}
