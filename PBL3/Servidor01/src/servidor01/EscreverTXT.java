/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author wstro
 */
public class EscreverTXT {
    private LinkedList<LinkedList<String>> palavras;
    
    private LinkedList<LinkedList<String>> usuario;
    private LinkedList<LinkedList<String>> historico;
  
    
     /*
    Nesse classe irá conter toda a configuração da base de dados dos servidores.
    como leitura de dados cadastrados, dados dos livros e histórico. 
    Alem de metodos como gravar e txt de cada dado
    
    */  
    public EscreverTXT() throws IOException{
     
        palavras = new LinkedList<LinkedList<String>>();
        
        usuario= new LinkedList<LinkedList<String>>();
        historico= new LinkedList<LinkedList<String>>();
        
       /* gravar();
        
        ler();        
        lerUsuario();*/
    }
    
    public void gravar() throws IOException{
        File arquivo = new File("dados.txt"); 
        
        try(FileWriter abrirArquivo = new FileWriter( arquivo ); BufferedWriter br = new BufferedWriter( abrirArquivo )) {
            Iterator at= palavras.iterator();
           int contador=0;
           for(int x=0; x<palavras.size(); x++){
                      br.append(palavras.get(contador).get(0)+"-"+palavras.get(contador).get(1)+"-"+palavras.get(contador).get(2) + "\n");
           contador++;
           
           }
            br.close(); 
        }
    }
    
    public void gravarDadosListar(LinkedList<LinkedList<String>> atual) throws IOException{
         File arquivo = new File("dados.txt"); 
       
        try(FileWriter abrirArquivo = new FileWriter( arquivo ); BufferedWriter br = new BufferedWriter( abrirArquivo )) {
           
           Iterator at= atual.iterator();
           int contador=0;
           for(int x=0; x<atual.size(); x++){
                      br.append(atual.get(contador).get(0)+"-"+atual.get(contador).get(1)+"-"+atual.get(contador).get(2) + "\n");
           contador++;
           
           }
          br.close(); 
        }
          
    }

    public void setPalavras(LinkedList<LinkedList<String>> palavras) {
        this.palavras = palavras;
    }
   public void gravarUsuario() throws IOException{
         File arquivo = new File("dadosUsuario.txt"); 
       
        try(FileWriter abrirArquivo = new FileWriter( arquivo ); BufferedWriter br = new BufferedWriter( abrirArquivo )) {
           
           Iterator at= usuario.iterator();
           int contador=0;
           for(int x=0; x<usuario.size(); x++){
                      br.append(usuario.get(contador).get(0)+"-"+usuario.get(contador).get(1)+"-"+usuario.get(contador).get(2) + "\n");
           contador++;
           
           }
          br.close(); 
        }
          
    }
   
    public void gravarHistorico() throws IOException{
         File arquivo = new File("historico.txt"); 
       
        try(FileWriter abrirArquivo = new FileWriter( arquivo ); BufferedWriter br = new BufferedWriter( abrirArquivo )) {
           
           Iterator at= historico.iterator();
           int contador=0;
           for(int x=0; x<historico.size(); x++){
                      br.append(historico.get(contador).get(0)+"-"+historico.get(contador).get(1) + "\n");
           contador++;
           
           }
          br.close(); 
        }
          
    }
    /* public void gravarUsuario() throws IOException{
        File arquivo = new File("dadosUsuario.txt"); 
        
        try(FileWriter abrirArquivo = new FileWriter( arquivo ); BufferedWriter br = new BufferedWriter( abrirArquivo )) {
            String[] bancoPalavras = {"wstroks-wsotrks123-wstroks@gmail.com", "tim-tim123-tim@gmail.com"};
            for (String palavra : bancoPalavras) {
                br.append(palavra + "\n");//ecreve no arquivo
            }
            br.close(); 
        }
    }*/
     public void lerUsuario() throws IOException{
        File arquivo = new File("dadosUsuario.txt"); 
        
        try(FileReader lerArquivo = new FileReader( arquivo ); BufferedReader br = new BufferedReader( lerArquivo )) {
            String linha = br.readLine(); //ler a primeira linha do arquivo
            
            while(linha != null){ //repete atÃ© chegar no final do arquivo
                String[] result = linha.split("-"); //divide a linha em 2 arrays: Palavra e dica 
                addUsuario(result[0], result[1], result[2]); //adiciona a palavra com a dica
                
                linha = br.readLine(); //passa para a prÃ³xima linha
            }
            br.close();
        }
    }
     
    
    public void ler() throws IOException{
        File arquivo = new File("dados.txt"); 
        
        try(FileReader lerArquivo = new FileReader( arquivo ); BufferedReader br = new BufferedReader( lerArquivo )) {
            String linha = br.readLine(); //ler a primeira linha do arquivo
            
            while(linha != null){ //repete atÃ© chegar no final do arquivo
                String[] result = linha.split("-"); //divide a linha em 2 arrays: Palavra e dica 
                addPalavra(result[0], result[1], result[2]); //adiciona a palavra com a dica
                
                linha = br.readLine(); //passa para a prÃ³xima linha
            }
            br.close();
        }
    }
    public void lerHistorico() throws IOException{
        File arquivo = new File("historico.txt"); 
        
        try(FileReader lerArquivo = new FileReader( arquivo ); BufferedReader br = new BufferedReader( lerArquivo )) {
            String linha = br.readLine(); //ler a primeira linha do arquivo
            
            while(linha != null){ //repete atÃ© chegar no final do arquivo
                String[] result = linha.split("-"); //divide a linha em 2 arrays: Palavra e dica 
                addHistorico(result[0], result[1]); //adiciona a palavra com a dica
                
                linha = br.readLine(); //passa para a prÃ³xima linha
            }
            br.close();
        }
    }
    private void addPalavra(String palavra, String valor,String quantidade){
        LinkedList palavrasAux = new LinkedList();
        
        
        int x=Integer.parseInt(quantidade);
        double z=Double.parseDouble(valor);
       
        
        palavrasAux.add(palavra);
        palavrasAux.add(valor);
        palavrasAux.add(quantidade);
        
        palavras.add(palavrasAux);
        
    }
    public void addUsuario(String a, String senha, String email){
        LinkedList palavrasAux = new LinkedList();
        //ArrayList<Compras> a=  new ArrayList<Compras>();
        
        
     
        
        palavrasAux.add(a);
        palavrasAux.add(senha);
        palavrasAux.add(email);
        
        usuario.add(palavrasAux);
    }
    public void addHistorico(String a, String valor){
        LinkedList palavrasAux = new LinkedList();
        //ArrayList<Compras> a=  new ArrayList<Compras>();
        
        
       
        
        palavrasAux.add(a);
        palavrasAux.add(valor);
      
        
        historico.add(palavrasAux);
    }
    
    public LinkedList getList(){
        return this.palavras; //retorna lista de palavras
    }
    
    public LinkedList getListUser(){
        return this.usuario;
    }
     public LinkedList getListHistorico(){
        return this.historico;
    }
 
    
  
        
    
}
