package br.ecomp.uefs.cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
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
        public static DataInputStream entrada;
        public static DataOutputStream enviar;
        //public static ObjectInputStream recebetxt;
        
        public static ClienteServidores q;
        public static String ipReal;
        public static int portaRal;
             /*
        essa classe irá fazer primeiro a conexão com servidor endereçamento receber as informações de qual servidor
        secundário irá o cliente. Também nessa classe é iniciado as telas atraves do Cliente.show
        */   
        public static void main(String[] args) throws IOException, ClassNotFoundException  {
            String enderaco="192.168.43.103";
            int porta=1237;
            
           
                Socket cliente= new Socket(enderaco,porta);
                entrada = new DataInputStream(cliente.getInputStream());
                enviar = new DataOutputStream((cliente.getOutputStream()));
                //recebetxt= new ObjectInputStream(cliente.getInputStream());
                new Cliente().show();
                enviar.writeUTF("cliente");
             String  servidorEn= entrada.readUTF();
             int servidorP= entrada.readInt();
             System.out.print("ip" +servidorEn);
                System.out.print("estou na porta:"+ servidorP);
                 new ClienteServidores(servidorEn, servidorP);
                while(true){
                    String n=entrada.readUTF();
                    
                
                }
        }
    
}
