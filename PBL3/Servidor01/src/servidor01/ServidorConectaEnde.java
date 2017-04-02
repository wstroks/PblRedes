/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
public class ServidorConectaEnde extends Thread {
  
    
    private Socket cliente;
    public static DataOutputStream saidaDados;
    private DataInputStream entradaDados;
    private EscreverTXT txt;
    public static ObjectOutputStream enviartxt;
    public static ObjectInputStream recebe;
    private ObjectOutputStream envia;
    private int contador=1;
   
    /*
    Essa classe irá se conectar com o Servidor endereçamento 
    para quando o cliente enviar o dados base ele atualiza o Servidor endereçamento e assim o servidor endereçamento atualizar todos 
    os servidores ativos.
    */
    public ServidorConectaEnde(Socket c) throws IOException, SQLException{
          cliente = c;
        saidaDados= new DataOutputStream(cliente.getOutputStream());//esse comando envia dados do servidor para o cliente/jagador
        entradaDados= new DataInputStream(cliente.getInputStream());//recebe informação do cliente
      /*
        Aque está contido as informações a serem enviadas para se conectar com servidor secundário
        */
       saidaDados.writeUTF("servidor");
       saidaDados.writeUTF("192.168.43.103");
       saidaDados.writeInt(1234);
       txt= new EscreverTXT();
       enviartxt= new ObjectOutputStream(cliente.getOutputStream());
       recebe= new ObjectInputStream(cliente.getInputStream());
       System.out.println("servi");
       
                
        
    }
    
    
    
    @Override
    public void run(){
            
            try {
                
                while(true){
                 
                  
                    
                if(cliente.isConnected()){
                
                    String h=null;
                   
                   h=entradaDados.readUTF();
                  /*
                   Essa condição recebe o txt do servidor endereçamenta mais atualizado e grava no servidor 
                   assim deixando a todo momento o servidor secundário atualizado
                   */
                   if(h.equals("enviarTxt")){
                       System.out.println("recebe txt do servidor");
                        LinkedList<LinkedList<String>>lista = new LinkedList<LinkedList<String>>();
                      lista= (LinkedList<LinkedList<String>>) recebe.readObject();
                      EscreverTXT txt= new EscreverTXT();
                      txt.setPalavras(lista);
                      txt.gravar();
                      ThreadConect.saidaDados.writeUTF("atual");
                   System.out.println(lista.get(0));
                   
                   }
                   
                   
                  
                  
                  
                  
                  
              
                
                saidaDados.flush();
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
                System.out.println(ex.toString());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServidorConectaEnde.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
