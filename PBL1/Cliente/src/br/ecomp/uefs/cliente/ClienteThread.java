package br.ecomp.uefs.cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pagotto
 */
public class ClienteThread {
    /*
    Recebendo as informaçoes ou solitando para o servidor
    */
        public DataInputStream entrada;
        public DataOutputStream enviar;
                
        public ClienteThread(){
            String enderaco="localhost";
            int porta=1234;
            
            try {
                Socket cliente= new Socket(enderaco,porta);
                entrada = new DataInputStream(cliente.getInputStream());
                enviar = new DataOutputStream((cliente.getOutputStream()));
            }catch(IOException ex) {
                 System.out.println(ex.toString());
            }
        }
        /*
        public static void main(String[] args) throws InterruptedException{
            
            
            
            
            try {
                Socket cliente= new Socket(enderaco,porta);
                DataInputStream entrada = new DataInputStream(cliente.getInputStream());
                DataOutputStream enviar= new DataOutputStream((cliente.getOutputStream()));
                //enviar.writeUTF(enderaco);
                
                
                
                while(true){
                    System.out.println(entrada.readUTF());
                    Thread.sleep(1000);
                }
            } catch (IOException ex) {
                 System.out.println(ex.toString());
            }
        }*/
}
