/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpbl2;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pagotto
 */
public class ServidorThread {
    
    
       /*
        Existe duas maneiras de se usar Thread mas conceitualmente(
        utilziando o extends Thread ou usando o implements runnable ... QUAL diferença dos dois.. Primeiro extendendo o Thread
        vc poderá utilizar varios metodos seja o start o stop e etc.. além de escrever novamente o metodo run ... Já o implements
        vc só poderá utilizar e escrever novamente o metodo run.
        ISSo se chama thread Main .. usando um thread extendido e chamando na main
        */
        public static ArrayList<Jogador> jogadoresSalas;
        public static ArrayList<SalaSV> salas;
        private  static ClienteBd  clienteadd;
        private static Palavra p;
        private static Controller c;
       public static void main(String[] args) throws SQLException, InterruptedException{
           
            int porta=1234;//numeração da porta escolhida
            salas= new ArrayList<SalaSV>();
            jogadoresSalas= new ArrayList<Jogador>();
            clienteadd= new ClienteBd();
            p = new Palavra();
            c= new Controller();
            
           try {
               ServerSocket servidor= new ServerSocket(porta);//criando o servidor e numeroado a porta
               while(true){
                  Socket conexao = servidor.accept(); // inicializando a conexao
                  
                  System.out.println("Porta do Cliente:" + conexao.getPort());// printando a conexao 
                  System.out.println("Porta do Cliente:" + conexao.getLocalPort());
                  Jogador n;
                  String nome=null;
                  DataInputStream recebe = new DataInputStream(conexao.getInputStream());
                   DataOutputStream enviar = new DataOutputStream(conexao.getOutputStream());
                  nome=recebe.readUTF();
                    
                  int po = sorteandoPorta();
                  n= new Jogador(conexao,nome,po);
           ThreadConect t =new ThreadConect(conexao);// esse comando que chama o threadConect, que a onde está presente todo o nosso protocolo
                  t.start();
           jogadoresSalas.add(n);
                  System.out.println("nome:"+ nome + po);
                enviar.writeInt(po);
                  
                  if(jogadoresSalas.size()==2){
                      System.out.println("aa");
                      jogadoresSalas.get(0).envia.writeUTF(jogadoresSalas.get(1).jogador.getInetAddress().toString());
                      jogadoresSalas.get(0).envia.writeInt(jogadoresSalas.get(1).porta);
                      jogadoresSalas.get(0).envia.writeUTF(jogadoresSalas.get(1).nome);
                      System.out.println("envia 1");
                      
                      jogadoresSalas.get(1).envia.writeUTF(jogadoresSalas.get(0).jogador.getInetAddress().toString());
                      jogadoresSalas.get(1).envia.writeInt(jogadoresSalas.get(0).porta);
                      jogadoresSalas.get(1).envia.writeUTF(jogadoresSalas.get(0).nome);
                      Palavra p[] = new Palavra[4];
                      p[0]=c.sort(1);
                      p[1]=c.sort(2);
                      p[2]=c.sort(3);
                      p[3]=c.sort(4);
                      for(int i=0; i<jogadoresSalas.size(); i++){
                        
                        jogadoresSalas.get(i).envia.writeUTF(p[0].getPalavra());
                        jogadoresSalas.get(i).envia.writeUTF("não tem tema"); 
                        
                        jogadoresSalas.get(i).envia.writeUTF(p[1].getPalavra());
                        jogadoresSalas.get(i).envia.writeUTF(p[1].getTema());
                       
                        
                        
                        jogadoresSalas.get(i).envia.writeUTF(p[2].getPalavra());
                        jogadoresSalas.get(i).envia.writeUTF(p[2].getTema());
                        
                        
                        
                        jogadoresSalas.get(i).envia.writeUTF(p[3].getPalavra());
                        jogadoresSalas.get(i).envia.writeUTF(p[3].getTema());
                          
                      }
                      salas.add(new SalaSV(jogadoresSalas));
                      jogadoresSalas = new ArrayList<Jogador>();
                              
                  }
                  
                  
                  
                  Thread.sleep(2000);
               }
               
           } catch (IOException ex) {
               System.out.println(ex.toString());
           }
            
       }
       
       
       public static int sorteandoPorta(){
           Random n = new Random();
           
          int a= n.nextInt(100)+ 5400;
          
          return a;
       }
}
