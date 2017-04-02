/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wstro
 */
public class ClientePBL extends Thread  {

    /**
     * @param args the command line arguments
     */
    
    
    public static int porta;
    ServerSocket servidor;
    public DataOutputStream mandaSala;
    public  DataInputStream recebeSala;
    public static ArrayList<JogadorCLiente> jogadores;
    public static ArrayList<ThreadCliente> agoraVai;
    public static ThreadCliente a;
    
    public  ClientePBL(int x,ArrayList<ThreadCliente> con) throws SQLException, InterruptedException, IOException   {
        // TODO code application logic here
              porta = x;
              servidor= new ServerSocket(porta);//criando o servidor e numeroado a porta
               //System.out.println("inicia "+ porta);
           agoraVai=con;
               
           
            
    }
    
    public void run(){
        try {
               
               while(true){
                  Socket conexao = servidor.accept(); // inicializando a conexao
                  mandaSala= new DataOutputStream(conexao.getOutputStream());
                  recebeSala= new DataInputStream(conexao.getInputStream());
                  System.out.println("aque "+ porta);
                  System.out.println("Porta do Cliente:" + conexao.getPort());// printando a conexao 
                  System.out.println("Porta do Cliente:" + conexao.getLocalPort());
                  a= new ThreadCliente(conexao);
                  a.start();// esse comando que chama o threadConect, que a onde está presente todo o nosso protocolo
                  //new ClientePBL(porta);
                  agoraVai.add(a);
                  //a.mandaSala.writeUTF("kkkahahahaha");
                  System.out.println(recebeSala.readUTF());
                  //int z=recebeSala.readInt();
                 // System.out.println(" pontuacao :" + z);
                  boolean x= true;
                 
                  
                  Thread.sleep(1000);
                  
                   
               }
               
           } catch (IOException ex) {
               System.out.println(ex.toString());
           } catch (SQLException ex) {
            Logger.getLogger(ClientePBL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ClientePBL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
