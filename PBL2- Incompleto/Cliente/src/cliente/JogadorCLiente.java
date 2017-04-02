/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import static cliente.ClienteThread.finalNome;
import static cliente.ClienteThread.jogadores;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author wstro
 */
public class JogadorCLiente {
    
        public String nome;
        public Socket jogador;
        public DataOutputStream Menvia;
        public DataInputStream Mrecebe;
        public static ArrayList<JogadorCLiente> jogadores;
        
        
        public JogadorCLiente(String nome, int porta, String ip) throws IOException, InterruptedException, SQLException{
            jogador= new Socket(ip, porta);
            this.nome = nome;
            jogadores= new ArrayList<>();
            Menvia= new DataOutputStream(jogador.getOutputStream());
            Mrecebe= new DataInputStream(jogador.getInputStream());
            
            Menvia.writeUTF("kkkkksera");
            //System.out.println("classe jogador"+Mrecebe.readInt());
            
          
            
            
                 
                
                
        }
        
        
        
        
}
