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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Pagotto
 */
public class ThreadConect extends Thread {
        
    private Socket conexao;
    private DataOutputStream saidaDados;
    private DataInputStream entradaDados;
    private ClienteBd  clienteadd;
    private Palavra p;
    
    
    private int contador=1;
    
    /*
    é necessario ter no construtor uma porta socket pois sem ela n consiguiriamos inicializar o threadmain
    */
    public ThreadConect(Socket socket) throws IOException, SQLException{
        conexao=socket;
        saidaDados= new DataOutputStream(conexao.getOutputStream());//esse comando envia dados do servidor para o cliente/jagador
        entradaDados= new DataInputStream(conexao.getInputStream());//recebe informação do cliente
        Controller c= new Controller();// utiliza metodos como o sort
        clienteadd= new ClienteBd();
        
        
    }
    
    /*
    AQUE está presente o nosso Protocolo, a logica é apos a conexao com o servidor o cliente enviará uma String P1
    que corresponde a primeira rodada, retornando a palavra sem a dica.. Assim por diante nas proximas rodadas que são
    P2,P3,P4 mas enviando a palavra e a dica.. a condição FINAL e quando o jogo está finalizado o cliente/jogador enviará 
     a sua pontuação e o nome do jogador... já a condição TOpP retornará para o cliente os 3 maiores pontuados do jogo 
    */
    
    @Override
    public void run(){
            
            while(true){
                if(conexao.isConnected()){
                    
                    String controla=null;
                    try {
                        controla= entradaDados.readUTF();
                         if(controla.equals("FIM")){
                                    System.out.println(entradaDados.readUTF());
                         }
                         else if(controla.equals("finalJogo")){
                             int x= entradaDados.readInt();
                             System.out.println(x);
                             String nome= entradaDados.readUTF();
                             System.out.println(nome);
                             Cliente a= new Cliente();
                             a.setNome(nome);
                             a.setPontuacao(x);
                             clienteadd.cadastrarCliente(a);
                         }
                         else if(controla.equals("topP")){
                             int x=0;
                             ArrayList<Cliente> cliente= new ArrayList<>();
                             
                             cliente=clienteadd.listarC();
                             Iterator it= cliente.iterator();
                             
                             while(it.hasNext()){
                                 Cliente a= new Cliente();
                                 a=(Cliente) it.next();
                                  saidaDados.writeUTF(a.getNome());
                                  saidaDados.writeInt(a.getPontuacao());
                                  x++;
                                  
                             }
                             if(contador<3){
                                  saidaDados.writeUTF("fim");}
                         }
                    } catch (IOException ex) {
                        Logger.getLogger(ThreadConect.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ThreadConect.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
            }
    
}

}