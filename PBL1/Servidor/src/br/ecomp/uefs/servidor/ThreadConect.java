/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.servidor;

import br.ecomp.uefs.facade.Controller;
import br.ecomp.uefs.model.Cliente;
import br.ecomp.uefs.model.Palavra;
import br.ecomp.uefs.util.ClienteBd;
import br.ecomp.uefs.util.PalavraBD;

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
    private DataInputStream entradaDados;
    private Controller c;
    private Palavra g;
    private int contador=1;
    private ClienteBd clienteadd;
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
            
            try {
                Controller c = new Controller();
                while(true){
                 
                  
                    
                if(conexao.isConnected()){
                   String h=null;
                   
                   h=entradaDados.readUTF();
                  
                   
                   if(h.equals("p1")){
                       System.out.println("palavra1");
                        g=c.sort(1);
                       saidaDados.writeUTF(g.getPalavra());
                       
                   }
                   
                   else if(h.equals("p2")){
                       System.out.println("palavra2");
                        g=c.sort(2);
                        saidaDados.writeUTF(g.getPalavra());
                        saidaDados.writeUTF(g.getTema());
                        
                   }
                   else if(h.equals("p3")){
                       System.out.println("palavra3");
                        g=c.sort(3);
                        saidaDados.writeUTF(g.getPalavra());
                        saidaDados.writeUTF(g.getTema());
                       
                   }
                   else if(h.equals("p4")){
                        g=c.sort(4);
                        saidaDados.writeUTF(g.getPalavra());
                        saidaDados.writeUTF(g.getTema());
                        
                   }
                   else if(h.equals("final")){
                       String b;
                       int a;
                       Cliente add= new Cliente();
                       
                       a=entradaDados.readInt();//pontuacao
                       b=entradaDados.readUTF();//nome]
                       
                       System.out.println("Jogador:"+b+ "Pontuacao:"+a);
                       //adiciona a pontuacao e jogador no bd
                       add.setNome(b);
                       add.setPontuacao(a);
                       clienteadd.cadastrarCliente(add);
                   }
                  
                   else if(h.equals("topP")){//3 pontuacoes
                      
                       boolean sair=true;
                       int contador=0;
                       ArrayList<Cliente> x= new ArrayList<>();
                       
                       x=clienteadd.listarC();
                       Iterator it=x.iterator();
                       // como eu só preciso dos 3 primeiros quando sair do .. quando contador==3 ele sai do while
                       while(it.hasNext()){
                        
                           Cliente cliente= (Cliente) it.next();
                        
                        saidaDados.writeUTF(cliente.getNome());
                        saidaDados.writeInt(cliente.getPontuacao());
                         contador++;
                       }
                       if(contador<3)
                           saidaDados.writeUTF("fim");
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
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        } 
    }
    
}
