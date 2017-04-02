/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Pagotto
 */
public class ThreadCliente extends Thread {
        
    private Socket conexao;
    public DataOutputStream mandaSala;
    public  DataInputStream recebeSala;
    public int geralPontuacao;
    
    
    private int contador=1;
    
    /*
    é necessario ter no construtor uma porta socket pois sem ela n consiguiriamos inicializar o threadmain
    */
    public ThreadCliente(Socket socket) throws IOException, SQLException{
        this.conexao=socket;
        mandaSala= new DataOutputStream(conexao.getOutputStream());//esse comando envia dados do servidor para o cliente/jagador
        recebeSala= new DataInputStream(conexao.getInputStream());//recebe informação do cliente
        
        
        
    }
     public Socket getConexao(){
        return conexao;
    }
    
    /*
    AQUE está presente o nosso Protocolo, a logica é apos a conexao com o servidor o cliente enviará uma String P1
    que corresponde a primeira rodada, retornando a palavra sem a dica.. Assim por diante nas proximas rodadas que são
    P2,P3,P4 mas enviando a palavra e a dica.. a condição FINAL e quando o jogo está finalizado o cliente/jogador enviará 
     a sua pontuação e o nome do jogador... já a condição TOpP retornará para o cliente os 3 maiores pontuados do jogo 
    */
    
    @Override
    public void run(){
            
            /*while(true){
                
                if(conexao.isConnected()){
                    
                    try {
                        String organiza= null;
                        organiza=recebeSala.readUTF();
                        if(organiza.equals("venceu")){
                            TelaJogo a= new TelaJogo();
                           int x=a.geralPontuacao;
                            mandaSala.writeInt(a.geralPontuacao);
                            System.out.println(x);
                        }
                        else if(organiza.equals("palavra")){
                            mandaSala.writeUTF("aa");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }*/
                
            }

    
    
}

