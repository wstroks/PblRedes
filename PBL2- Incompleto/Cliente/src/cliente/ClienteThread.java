package cliente;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
        public static ClientePBL sv;
                
      /*  public ClienteThread(){
            String enderaco="localhost";
            int porta=1234;
            
            try {
                Socket cliente= new Socket(enderaco,porta);
                entrada = new DataInputStream(cliente.getInputStream());
                enviar = new DataOutputStream((cliente.getOutputStream()));
            }catch(IOException ex) {
                 System.out.println(ex.toString());
            }
        }*/
        public static ArrayList<JogadorCLiente> jogadores;
        private int contador=0;
        public static String[] palavra;
        public static String[] tema;
        public static ArrayList<Palavra> agora;
        public static  String finalNome;
        public static ArrayList<IP> y;
        public static ArrayList<ThreadCliente> pblSala;
        public static IP m;
        public static JogadorCLiente jogaCliente;
        public static ClientePBL serv;
        
        
        
      /* public static void main(String []args) throws InterruptedException, SQLException, IOException{
            ClienteThread cliente = new ClienteThread();
            TelaJogo jogo = new TelaJogo();
                 jogo.show();
                 jogo.iniciar();
                 
                 
                 jogo.setVisible(true);
        }*/
        
        public ClienteThread()throws InterruptedException, SQLException, IOException{
            
            jogadores= new ArrayList<JogadorCLiente>();
            agora= new ArrayList<Palavra>();
            y= new ArrayList<IP>();
            pblSala= new ArrayList<ThreadCliente>();
            String enderaco="192.168.1.6";
            int porta=1234;
            
            
                Socket cliente= new Socket(enderaco,porta);
                entrada = new DataInputStream(cliente.getInputStream());
                enviar = new DataOutputStream((cliente.getOutputStream()));
                finalNome =JOptionPane.showInputDialog("Digite seu nome:" , "");
                enviar.writeUTF(finalNome);
                int minhaporta=entrada.readInt();
                System.out.println("porta recebida"+ minhaporta); 
                
                
                
                
                 String ip= entrada.readUTF();
                 int po= entrada.readInt();
                String nome= entrada.readUTF();
                ip = ip.substring(1, ip.length());
                m =new IP();
               m.setIp(ip);
               m.setNome(nome);
               m.setPorta(po);
               
               y.add(m);
                System.out.println("Conectando com:"+ nome +"  Porta :"+po +" IP :"+ip);
                 palavra= new String[4];
                 tema= new String[4];
                for(int x=0; x<4; x++){
                    palavra[x]= entrada.readUTF();
                    tema[x]=entrada.readUTF();
                    Palavra a= new Palavra();
                    a.setPalavra(palavra[x]);
                    a.setTema(tema[x]);
                    agora.add(a);
                    System.out.println("ahah" + agora.get(0).getPalavra());
                    System.out.println("palavra :" +palavra[x]);
                    System.out.println("Tema:" +tema[x]);
                }
                
                System.out.println("vai iniciar");
                
                  serv =new ClientePBL(minhaporta,pblSala);
                
                 serv.start();
                jogaCliente= new JogadorCLiente(nome, po, ip);
                 //System.out.println(serv.recebeSala.readUTF());
                // JogadorCLiente jogaCliente= new JogadorCLiente(nome, po, ip);
                 //new ClienteSala();
                
                 //jogo.desabilit();
               /*JogadorCLiente jogaCliente= new JogadorCLiente(nome, po, ip);
                TelaJogo jogo;
                jogadores.add(jogaCliente);
                if(jogaCliente.nome.compareTo(finalNome)<0){
                    //System.out.println("Jogador 1");
                 jogo = new TelaJogo(jogadores, 1);
                 jogo.setVisible(true);
                 jogo.iniciar();
                 jogo.habilit();
                 String letra = jogaCliente.Mrecebe.readUTF();
                    while(true){
                     //String letra = jogaCliente.recebe.readUTF();
                     //System.out.println(letra);
                      System.out.println("hahahaha:" +letra);
                     jogo.jogar(letra, false);
                     jogo.habilit();
                    }
                 
                }
                else{
                    System.out.println("Jogador 2");
                 jogo = new TelaJogo(jogadores, 2);
                 
                 jogo.iniciar();
                 jogo.setVisible(true);
                 jogo.desabilit();
                 
                     String letra = jogaCliente.Mrecebe.readUTF();
                     while(true){
                     System.out.println("hahahaha:" +letra);
                     jogo.jogar(letra, false);
                     jogo.habilit();
                     }
                 
                }*/
                
                }
              // enviar.writeUTF("FIM");
              //  enviar.writeUTF(nome);
            
           public static void main(String []args) throws IOException, InterruptedException, SQLException{
               System.out.println(m.getIp());
               System.out.println(m.getPorta());
               JogadorCLiente jogaCliente= new JogadorCLiente(m.getNome(), m.getPorta(), m.getIp());
           }
            
            
            
        }
    

      

