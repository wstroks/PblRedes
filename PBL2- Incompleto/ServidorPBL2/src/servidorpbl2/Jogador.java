/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorpbl2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author wstro
 */
public class Jogador {
    
        public int porta;
        public String ip;
        public String nome;
        public Socket jogador;
        public DataOutputStream envia;
        public DataInputStream recebe;
        
        
        public Jogador(Socket s,String n,int a) throws IOException{
            jogador=s;
            porta=a;
            nome=n;
            recebe= new DataInputStream(jogador.getInputStream());
            envia= new DataOutputStream(jogador.getOutputStream());
            
                 
            
            
        }
    
    
}
