/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnsmaster;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pagotto
 */
public class ServidorThreadDnS{
    
    
       /*
        ESSA THREAD EH RESPONSÁVEL PELO ENDEREÇAMENTO TANTO DO SERVIDOR QUANTO DO CLIENTE
        ELE FAZ CONEXÃO TANTO COM CLIENTE E DEPOIS REDIRECIONA PARA UM SERVIDOR E CONECTA COM SERVIDOR ATUALIZANDO SEU TXT.
    */
    
     private static DataOutputStream enviar;
     private static DataInputStream recebe;
    
     public static ArrayList<ArrayList<String>> servidores;
     public static ArrayList<ArrayList<String>> caiu;
     
    
     public static void main(String[] args) throws SQLException{
           
            int porta=1237;//numeração da porta escolhida
            servidores= new ArrayList<ArrayList<String>>();
          
           caiu = new ArrayList<ArrayList<String>>();
           
          
           try {
               int x=0;
               ServerSocket servidor= new ServerSocket(porta);//criando o servidor e numeroado a porta
                ServerSocket cai= new ServerSocket(1239);
               boolean servidor1=false;
              
               while(true){
                   
                   
                    
                  Socket conexao = servidor.accept(); // inicializando a conexao
           recebe= new DataInputStream(conexao.getInputStream());
           enviar= new DataOutputStream(conexao.getOutputStream());
                
                 
                 
                  System.out.println("Porta do Cliente:" + conexao.getPort());// printando a conexao 
                  System.out.println("Porta do Cliente:" + conexao.getLocalPort());
                  String n= recebe.readUTF();
                  System.out.println(n);
                  /*
                  lOGO QUE OH CLIENTE INICIA ELE ENVIA, A PALAVRA CLIENTE!!! ENVIAR PARA O SERVIDOR PORTA E IP PARA FAZER A CONEXAO
                  DO CLIENTE PARA SERVIDOR SECUNDÁRIO.. O BALANCEAMENTO É FEITO AQUE, OU SEJA, ATRAVES DE UMA LISTA QUE QUANDO ADICIONADO O CLIENTE
                  EH INSERIDO NO FINAL DA LISTA.
                  */
                      
                  if(n.equals("cliente")){
                      System.out.println("entrou cliente");
                      enviar.writeUTF(servidores.get(0).get(0));
                      enviar.writeInt(Integer.parseInt(servidores.get(0).get(1)));
                      ArrayList<String> aux= new ArrayList<String>();
                      System.out.println("tamanho da lista :"+servidores.size());
                      aux= servidores.get(0);
                      servidores.remove(0);
                      servidores.add(aux);
                      new ThreadConect(conexao).start();
                      EscreverTXT txt= new EscreverTXT();
                      txt.ler();
                      
                      ThreadConectServidor.saidaDadosServidor.writeUTF("enviarTxt");
                      ThreadConectServidor.enviartxt.writeObject(txt.getList());
                      
                  }
                  /*3
                  O MESMO VALE PARA O SERVIDOR, É CRIADO UM LISTA DE SERVIDORES. VERIFICANDO A TODO MOMENTO QUANDO SERVIDOR CAI.
                  É TRATO NA THRECONECTSERVIDOR. FOI SEPARADO DUAS THREADS UM DO CLIENTE E OUTRA DO SERVIDOR PARA AJUDAR 
                  NA CRIAÇÃO DO PROTOCOLO
                  */
                  else if(n.equals("servidor")){
                      
                      ArrayList<String> fdp = new ArrayList<String>();
                      ArrayList<String> po = new ArrayList<String>();
                      fdp.add(recebe.readUTF());
                      String aa= String.valueOf(recebe.readInt());
                      
                      fdp.add(aa);
                      fdp.add(String.valueOf(conexao.getPort()));
                      po.add(String.valueOf(conexao.getLocalPort()));
                      po.add(String.valueOf(conexao.getPort()));
                      po.add(String.valueOf(conexao.getPort()));
                      
                      caiu.add(po);
                      servidores.add(fdp);
                      System.out.println("entrou servidor :"+aa);
                      new ThreadConectServidor(conexao).start();
                      
                  }
               }
               
           } catch (IOException ex) {
               System.out.println("jkhkjfsg");
               System.out.println(ex.toString());
           }
            
       }
}
