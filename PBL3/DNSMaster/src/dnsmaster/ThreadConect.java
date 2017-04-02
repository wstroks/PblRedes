/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dnsmaster;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;



/**
 *
 * @author Pagotto
 */
public class ThreadConect extends Thread {
        
    private Socket conexao;
    private DataOutputStream saidaDados;
    public DataInputStream entradaDados;
    
    private int contador=1;
  
    /*
    é necessario ter no construtor uma porta socket pois sem ela n consiguimos manter a conexão com o cliente
    */
    public ThreadConect(Socket socket) throws IOException, SQLException{
        conexao=socket;
        saidaDados= new DataOutputStream(conexao.getOutputStream());//esse comando envia dados do servidor
        entradaDados= new DataInputStream(conexao.getInputStream());//recebe informação do cliente
    
       // clienteadd= new ClienteBd();
        
        
    }
    
    /*
    Só enviar para o cliente o ip e a porta do servidor secundario que é feito na classe servidorThread e após o envio finalizado a conexao
    */
    
    @Override
    public void run(){
            
            try {
                
                while(true){
                 
                  
                    
                if(conexao.isConnected()){
                   String h=null;
                   
                   h=entradaDados.readUTF();
                  
                   
                   
                   
                   
                   
                  
                  
                  
                  
              
                
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
        } 
    }
    
}
