/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.cliente;

import static br.ecomp.uefs.cliente.ClienteThread.entrada;
import static br.ecomp.uefs.cliente.ClienteThread.enviar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author wstro
 */
public class ClienteServidores extends Thread {
    //public static DataInputStream entradaServidores;
   // public static DataOutputStream enviarServidores;
    public static LinkedList<LinkedList<String>>  manolo;
    public static LinkedList<LinkedList<String>> login;
    
    public static ObjectInputStream receba;
    //public static ObjectOutputStream enviartxt;
    public static DataInputStream entradaSV;
    public static DataOutputStream enviarSV;
    
    /*
    aque irá ter todo o protocolo que irá atualizar o cliente, pois a conexao do servidor secundário que irá
    informar e guiar os clientes com suas informações
    */
    public ClienteServidores(String a, int b) throws ClassNotFoundException{
            String enderaco=a;
            int porta=b;
            
            try {
                
                login= new LinkedList<LinkedList<String>> ();
                manolo= new LinkedList<LinkedList<String>> ();
                Socket cliente= new Socket(enderaco,porta);
                
                entradaSV = new DataInputStream(cliente.getInputStream());
                enviarSV= new DataOutputStream((cliente.getOutputStream()));
                receba= new ObjectInputStream(cliente.getInputStream());
               // enviar= new ObjectOutputStream(cliente.getOutputStream());
                //enviar.writeUTF("Serv1");
                enviarSV.writeUTF("txt");
                
                
                while(true){
                    String c=entradaSV.readUTF();
                    System.out.println(c);
                    /*
                    recebe a lista e dados dos livros logo quando conecta com os servidores
                    */
                    if(c.equals("lista")){
                       
                        System.out.println("auqe");
                      manolo= (LinkedList<LinkedList<String>>) receba.readObject();
                      Iterator it = manolo.iterator();
                      while(it.hasNext()){
                          
                          LinkedList<LinkedList<String>> palavras=(LinkedList<LinkedList<String>>) it.next();
                          System.out.println("Nome do livro: "+palavras.get(0));
                          System.out.println("Valor do livro:  "+palavras.get(1));
                          System.out.println("Quantidade disponivel:  "+palavras.get(2));
                      }
                      
                      
                    }
                   /*
                    eh recebido os usuarios ja cadastrados do sistema
                    */
                   else if(c.equals("login")){
                        login=(LinkedList<LinkedList<String>>) receba.readObject();
                       Iterator at= login.iterator();
                        while(at.hasNext()){
                          
                          LinkedList<LinkedList<String>> o=(LinkedList<LinkedList<String>>) at.next();
                          System.out.println("login: "+o.get(0));
                          System.out.println("senha:  "+o.get(1));
                          System.out.println("email:  "+o.get(2));
                      }
                }
                    
                  else if(c.equals("at")){
              login=(LinkedList<LinkedList<String>>) receba.readObject();
              System.out.println("foi lista");
              Iterator it= login.iterator();
                        while(it.hasNext()){
                          
                          LinkedList<LinkedList<String>> o=(LinkedList<LinkedList<String>>) it.next();
                          System.out.println("login 2: "+o.get(0));
                          System.out.println("senha:  "+o.get(1));
                          System.out.println("email:  "+o.get(2));
                      }
              
                  }/*
                  recebe as informações dos livros novamente
                  */
                  else if(c.equals("dados")){
                      manolo=(LinkedList<LinkedList<String>>) receba.readObject();
                       System.out.println("foi lista dados");
              Iterator at= login.iterator();
                        while(at.hasNext()){
                          
                          LinkedList<LinkedList<String>> o=(LinkedList<LinkedList<String>>) at.next();
                          System.out.println("Livro 2: "+o.get(0));
                          System.out.println("valor 2:  "+o.get(1));
                          System.out.println("qtd 2:  "+o.get(2));
                      }
                  }
                  else if(c.equals("atual")){
                      enviarSV.writeUTF("txt");
                  }/*
                  atualiza a lista de dados dos livros 
                  */
                  else if(c.equals("vem")){
                      System.out.println("ahushasuuhas");
                      
                      int x=entradaSV.readInt();
                      LinkedList<LinkedList<String>> NOVA = new LinkedList<>();
                       for(int z=0; z<x; z++){
                           LinkedList u= new LinkedList();
                           String nome=entradaSV.readUTF();
                           String valor=entradaSV.readUTF();
                           String qtd=entradaSV.readUTF();
                           u.add(nome);
                           u.add(valor);
                           u.add(qtd);
                           NOVA.add(u);
                           System.out.println(NOVA.get(z));
                       }
                      manolo= NOVA;
                      
                  }
                 
                    }
            }catch(IOException ex) {
                 System.out.println(ex.toString());
            }
        }
    }

