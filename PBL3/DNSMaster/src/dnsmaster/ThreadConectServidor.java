/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnsmaster;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wstro
 */
public class ThreadConectServidor extends Thread{
    private Socket conexao;
    public static DataOutputStream saidaDadosServidor;
    private DataInputStream entradaDados;
    public static ObjectInputStream recebetxt;
    public static ObjectOutputStream enviartxt;
    private EscreverTXT aque;
    
    private int contador=1;
   
    /*
    Aque vai está o protocolo que irá fazer a comunicação CLiente/servidor Secundário. Nela eh onde é enviado a base de dados, atualizado
    e mantido todas as informaçoes do cliente.
    */
    public ThreadConectServidor(Socket socket) throws IOException, SQLException{
        conexao=socket;
        saidaDadosServidor= new DataOutputStream(conexao.getOutputStream());//esse comando envia dados do servidor para o cliente
        entradaDados= new DataInputStream(conexao.getInputStream());//recebe informação do cliente
       
       aque= new EscreverTXT();
      
       recebetxt= new ObjectInputStream(conexao.getInputStream());
       enviartxt= new ObjectOutputStream(conexao.getOutputStream());
        
        
    }
    
   
    
    @Override
    public void run(){
            
            try {
                
                while(true){
                 
                  
                    
                if(conexao.isConnected()){
                   String h=null;
                   
                   h=entradaDados.readUTF();
                  
                   
                  /*
                   Recebe a lista de dados dos livros, quantidade e valor e envia para o Servidores,
                   assim irá manter a base de dados sempre atualizados
                   */
                  if(h.equals("enviar")){
                      LinkedList<LinkedList<String>> nova =new LinkedList<LinkedList<String>>();
                      nova= (LinkedList<LinkedList<String>>) recebetxt.readObject();
                      EscreverTXT txt= new EscreverTXT();
                      for(int x=0; x<nova.size(); x++){
                          System.out.println("aque ahahaha"+nova.get(x));
                      }
                      txt.setPalavras(nova);
                      txt.gravar();
                      //txt.ler();
                      
                      saidaDadosServidor.writeUTF("enviarTxt");
                      enviartxt.writeObject(txt.getList());
                  }
                  
                  
                  
                  
              
                
                saidaDadosServidor.flush();
                Thread.sleep(1000);
                }
                
                else{
                    contador=1;
                    break;
                }
                  contador ++;
                
                }
            }  catch (InterruptedException ex) { 
              
                System.out.println(ex.toString());
                } catch (IOException ex) {
                    /*
                    Nessa exeption é onde eu removo a da lista de servidores que estão funcionando,
                    quando um servidor cai. para que assim não tenha erro quando um cliente se conecta a um servidor 
                    não operando.
                    */
                      System.out.println(conexao.getPort());
                      for(int x=0; x<ServidorThreadDnS.caiu.size(); x++){
                      
                      String en= ServidorThreadDnS.caiu.get(x).get(1);
                      String ves=ServidorThreadDnS.caiu.get(x).get(2);
                      
                      
                     
                      
                      String verifica1=String.valueOf(conexao.getLocalPort());
                      String v=String.valueOf(conexao.getPort());
                     
                      if(v.equals(en)){
                          System.out.println("porta que saiu servidor: "+en);
                         for(int z=0; z<ServidorThreadDnS.servidores.size(); z++){
                             String haha=ServidorThreadDnS.servidores.get(z).get(2);
                             if(ves.equals(haha)){
                                 ServidorThreadDnS.servidores.remove(z);
                             }
                         }
                      }
                      
                      }
                      
                System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ThreadConectServidor.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
