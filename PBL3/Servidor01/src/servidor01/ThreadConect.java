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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Pagotto
 */
public class ThreadConect extends Thread {
        
    private Socket conexao;
    public static DataOutputStream saidaDados;
    private DataInputStream entradaDados;
    private EscreverTXT txt;
    private ObjectOutputStream enviartxt;
    private ObjectInputStream recebetxt;
    private ObjectOutputStream envia;
    private int contador=1;
   /* private Controller c;
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
       // Controller c= new Controller();// utiliza metodos como o sort
       // clienteadd= new ClienteBd();
       txt= new EscreverTXT();
       //recebetxt= new ObjectInputStream(conexao.getInputStream());
               
       enviartxt= new ObjectOutputStream(conexao.getOutputStream());
       //recebetxt= new ObjectInputStream(conexao.getInputStream());
       
       
        
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
                
                while(true){
                 
                  
                    
                if(conexao.isConnected()){
                   String h=null;
                   
                   h=entradaDados.readUTF();
                  
                   
                   if(h.equals("Serv1")){
                       System.out.println("servidor1");
                        
                       //saidaDados.writeUTF("conectou ao servidor 1");
                       contador ++;
                   }
                   /*
                   essa condição ele envia as informações da base de dados do servidor
                   ele envia os dados do livro e os cadastrados do sistema
                   */
                   else if(h.equals("txt")){
                       saidaDados.writeUTF("lista");
                       EscreverTXT aque= new EscreverTXT();
                      aque.ler();
                       
                       LinkedList<LinkedList<String>> b=aque.getList();
                       
                       enviartxt.writeObject(b);
                       txt.lerUsuario();
                      saidaDados.writeUTF("login");
                      LinkedList<LinkedList<String>> x= txt.getListUser();
                     
                     
                     enviartxt.writeObject(x);
                       
                   }
                  /*
                   essa condição é quando o usuario deseja cadastrar no sistema,
                   são enviados as informações como senha, login e email para a base de dados do sistema
                   */
                   
                   else if(h.equals("cadastro")){
                       
                       String usy= entradaDados.readUTF();
                       String senha= entradaDados.readUTF();
                       String email= entradaDados.readUTF();
                       txt.addUsuario(usy, senha, email);
                       txt.gravarUsuario();
                       txt.lerUsuario();
                       txt.getListUser();
                       System.out.println("agora vai :"+ usy);
                    
                   }
                   /*
                   Aque é caso ocora um nova atualização dos cadastrados ele enviar
                   a lista de cadastrados mais recente para o cliente
                   */
                   else if(h.equals("atualizatxt")){
                       System.out.println("aaaque");
                       saidaDados.writeUTF("login");
                       //txt.gravarUsuario();
                       txt.lerUsuario();
                       LinkedList<LinkedList<String>> x= txt.getListUser();
                       enviartxt.writeObject(x);
                       
                   }/*
                   nessa condição é enviado para o servidor, valor da compra e o seu login
                   para que assim seja construido o histórico de compras do cliente
                   */
                   else if(h.equals("finalizar")){
                       double x=entradaDados.readDouble();
                       String a= entradaDados.readUTF();
                       txt.lerHistorico();
                       txt.addHistorico(a, String.valueOf(x));
                       txt.gravarHistorico();
                       
                       System.out.println(x+"valor");
                        System.out.println(a+"nome");
                   }/*
                   aque é enviado os usuarios cadastrado para o sistema 
                   */
                   else if(h.equals("vamo")){
                       saidaDados.writeUTF("at");
                       
                      EscreverTXT a= new EscreverTXT();
                       a.lerUsuario();
                       LinkedList<LinkedList<String>> ol= a.getListUser();
                       enviartxt.writeObject(ol);
                       System.out.println("foi cadastro");
                       
                   }/*
                   quando a compra ja foi efetuado é enviado também quantos livros estão no estoque, ou seja,
                   enviado pelo cliente um lista contendo as informações da atualização 
                   e repassado para o Endereçamento que irá atualizar todos os servidores
                   */
                   else if(h.equals("terminando")){
                       int x=entradaDados.readInt();
                       LinkedList<LinkedList<String>> NOVA = new LinkedList<>();
                       for(int a=0; a<x; a++){
                           LinkedList u= new LinkedList();
                           String nome=entradaDados.readUTF();
                           String valor=entradaDados.readUTF();
                           String qtd=entradaDados.readUTF();
                           u.add(nome);
                           u.add(valor);
                           u.add(qtd);
                           NOVA.add(u);
                           System.out.println(NOVA.get(a));
                       }
                       //LinkedList<LinkedList<String>> NOVA=(LinkedList<LinkedList<String>>) recebetxt.readObject();
                       System.out.println("shs");
                       ServidorConectaEnde.saidaDados.writeUTF("enviar");
                       ServidorConectaEnde.enviartxt.writeObject(NOVA);
                   }/*
                   aque é a condição quando o cliente está comprando,quando ele adicionar um compra se a base de dados foi atualizada 
                   enviar a nova base para o cliente
                   */
                   else if(h.equals("aque")){
                        saidaDados.writeUTF("vem");
                       EscreverTXT vamos= new EscreverTXT();
                      vamos.ler();
                       LinkedList<LinkedList<String>> atual= new LinkedList<LinkedList<String>>();
                       
                       atual=vamos.getList();
                       System.out.println(atual.get(0));
                       System.out.println(atual.get(3));
                       
                     saidaDados.writeInt(atual.size());
             
             for(int x=0; x<atual.size(); x++){
                 
                 saidaDados.writeUTF(atual.get(x).get(0));
                saidaDados.writeUTF(atual.get(x).get(1));
                 saidaDados.writeUTF(atual.get(x).get(2));
                 
             }
                       
                       
                     
                     
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
        } 
    }
    
}
