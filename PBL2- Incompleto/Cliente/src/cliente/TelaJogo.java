/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import cliente.ClienteThread;
import cliente.Jogador;
import cliente.Recorde;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ianc
 */
public class TelaJogo extends javax.swing.JFrame {
    
    private int lvl;
    public String palavraAtual;
    public String tema;
    public String letrasTotais;
    public int pontuacaoAtual;
    public static int geralPontuacao;
    public ClienteThread c;
    private int vzs, sorteado;
    private boolean pronto;
    public static ArrayList<ThreadCliente> jogadores;
    public static int rival;
    
    /**
     * Creates new form TelaJogo
     */
    
    public TelaJogo(ClienteThread con) throws IOException {
        
        c = con;
        pontuacaoAtual = 0;
        geralPontuacao = 0;
        rival=0;
        
        initComponents();
        dica.setVisible(false);
        inf.setVisible(false);
        jButton1.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jSeparator1.setVisible(false);
        lLetra.setVisible(false);
        letras.setVisible(false);
        pontuacao.setVisible(false);
        rodada.setVisible(false);
        letras.setText("");
        lvl = 1;
         
    
    }
    public TelaJogo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void mostrar(String palavra, JLabel posicao){
        int i=0;
        
            posicao.setText(palavra); 
            
    }
    
    public void iniciar() throws IOException{
        letras.setText(" ");
        rodada.setText("RODADA "+lvl);
        pronto = false;
        dica.setVisible(true);
        dica.setText("");
        inf.setVisible(true);
        jButton1.setVisible(true);
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jSeparator1.setVisible(true);
        lLetra.setVisible(true);
        letras.setVisible(true);
        pontuacao.setVisible(true);
        rodada.setVisible(true);
        palavraAtual  = ClienteThread.agora.get(0).getPalavra();
      System.out.println(palavraAtual);
      //c.comunica();
    }
    
    public String indexar(String palavra, int soma){
        
        rodada.setText("RODADA "+lvl);
        int valor = 0;
        String proxima = null;
        System.out.println("vzs");
        if(palavra.contains(lLetra.getText()) && palavra != null){
            vzs++;
            valor = palavra.indexOf(lLetra.getText());
            valor = valor+ soma;
            System.out.println(valor + "test");
            if(valor==0)
                mostrar(lLetra.getText(),jLabel1);
            else if(valor==1)
                mostrar(lLetra.getText(),jLabel2);
            else if(valor==2)
                mostrar(lLetra.getText(),jLabel3);
            else if(valor==3)
                mostrar(lLetra.getText(),jLabel4);
            else if(valor==4)
                mostrar(lLetra.getText(),jLabel5);
            else if(valor==5)
                mostrar(lLetra.getText(),jLabel6);
            else if(valor==6)
                mostrar(lLetra.getText(),jLabel7);
            else if(valor==7)
                mostrar(lLetra.getText(),jLabel8);
            else if(valor==8)
                mostrar(lLetra.getText(),jLabel9);
            else if(valor==9)
                mostrar(lLetra.getText(),jLabel10);
            else if(valor==10)
                mostrar(lLetra.getText(),jLabel11);
            else if(valor==11)
                mostrar(lLetra.getText(),jLabel12);
            
        if(!letras.getText().contains(lLetra.getText()))
        proxima = palavra.substring(palavra.indexOf(lLetra.getText())+1, palavra.length());
        
        System.out.println("Palvra: " + proxima);
        if(proxima.contains(lLetra.getText())){
            indexar(proxima, palavraAtual.length() - proxima.length());
            if(!letras.getText().contains(lLetra.getText())){
            char a = '-';
            if(letras.getText().charAt(letras.getText().length()-1) == a){
                letras.setText(letras.getText()+lLetra.getText());
            } else {
                letras.setText(letras.getText()+"-"+lLetra.getText());
            }
        }
        else
            return null;
        }
        
            
        }
        return proxima;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        rodada = new javax.swing.JLabel();
        pontuacao = new javax.swing.JLabel();
        dica = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        inf = new javax.swing.JLabel();
        letras = new javax.swing.JLabel();
        lLetra = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        pontuacaoG = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        letras1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("__");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("__");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("__");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("__");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("__");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("__");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("__");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("__");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("__");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("__");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("__");

        rodada.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        rodada.setText("RODADA ");

        pontuacao.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pontuacao.setText("Pontuação Rodada:");

        dica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dica.setText("Dica");

        inf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        inf.setText("Letras :");

        letras.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        lLetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lLetraActionPerformed(evt);
            }
        });

        jButton1.setText("letra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("__");

        jButton2.setText("Sortear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ecomp/uefs/tela/roleta/roleta3.gif"))); // NOI18N

        pontuacaoG.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pontuacaoG.setText("Pontuação Geral:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("Você está jogando com:" + ClienteThread.y.get(0).getNome());

        letras1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(157, 157, 157))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rodada, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pontuacao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pontuacaoG, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel12)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(lLetra, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(dica, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(inf))
                    .addComponent(letras, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letras1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rodada)
                    .addComponent(pontuacao)
                    .addComponent(pontuacaoG))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dica)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lLetra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addGap(44, 44, 44)
                                .addComponent(inf)
                                .addGap(18, 18, 18)
                                .addComponent(letras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(letras1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)))
                        .addGap(61, 61, 61)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /*
    Quando o jogador passa de rodada os labels onde mostra as letras,
    é reiniciado com "__", para uma nova rodada.   
    
    */
    private void reiniciar(){
        rodada.setText("RODADA "+lvl);
        pronto = false;
        dica.setVisible(true);
        inf.setVisible(true);
        jButton1.setVisible(true);
        jSeparator1.setVisible(true);
        lLetra.setVisible(true);
        letras.setVisible(true);
        pontuacao.setVisible(true);
        rodada.setVisible(true);
        ocultar(lvl-1);
        jLabel1.setText("__");
        jLabel2.setText("__");
        jLabel3.setText("__");
        jLabel4.setText("__");
        jLabel5.setText("__");
        jLabel6.setText("__");
        jLabel7.setText("__");
        jLabel8.setText("__");
        jLabel9.setText("__");
        jLabel10.setText("__");
        jLabel11.setText("__");
        jLabel12.setText("__");
    }
    
    private void lLetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lLetraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lLetraActionPerformed

    /*
    Inicia o novo jogo.
    
    */
    private void novoJogo(){
        dica.setVisible(false);
        inf.setVisible(false);
        jButton1.setVisible(false);
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jSeparator1.setVisible(false);
        lLetra.setVisible(false);
        letras.setVisible(false);
        pontuacao.setVisible(false);
        rodada.setVisible(false);
    }
    
    
    /*
    A depender da rodada as Labels são setadas para true ou false,
    de acordo com a quantidade de letras da palavra.
    */
    private void ocultar(int id){
        if(id == 0 ){
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel10.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
        }else if(id == 1){
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
        }else if(id == 2){
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
        }else if(id == 3){
            jLabel11.setVisible(true);
            jLabel12.setVisible(true);
        }
    }
    
    /*
    Passa de Rodada
    */
    private void nextLvl() throws IOException, InterruptedException{
        letras.setText(" ");
        geralPontuacao = geralPontuacao + pontuacaoAtual;
        
        //Se ja estiver na 4 rodada ele envia para o servidor "final" e "topP",
        //para encerrar o jogo e receber as 3 melhores pontuações.
         if(lvl==4){
            String inputValue = ClienteThread.finalNome;
            String []pontuacoes = {"1.","2.","3."};
            String entrada;
            int cont = 0;
            c.enviar.writeUTF("finalJogo");
            c.enviar.writeInt(geralPontuacao);
            c.enviar.writeUTF(inputValue);
            c.enviar.writeUTF("topP");
            c.jogaCliente.Menvia.writeInt(geralPontuacao);
            //ival= c.serv.recebeSala.readInt();
          
             //sleep(4000);
            
                 
                 
             
            while(cont<3){
                entrada = c.entrada.readUTF();
                if(!entrada.equals("fim")){
                    pontuacoes[cont] = pontuacoes[cont] + entrada;
                    pontuacoes[cont] = pontuacoes[cont] + "  "+c.entrada.readInt();
                    cont++;
                }
                else{
                    /*
                    sala.mandaSala.writeUTF("venceu");
            int segundoJogador =sala.recebeSala.readInt();
            if(segundoJogador>geralPontuacao){
                JOptionPane.showInputDialog("voce perdeu");
                
            }
            else if(geralPontuacao>segundoJogador){
                JOptionPane.showInputDialog("voce VENCEU");
            }
            */
                    break;
                }
            }
            
            Recorde proximo = new Recorde(pontuacoes[0], pontuacoes[1], pontuacoes[2], c, geralPontuacao+"");
            proximo.show();
            this.setVisible(false);}
        
        
        //Caso ainda houver rodadas, ele envia para o servidor a mensagem referente a proxima rodada.
        else{       
        letras.setText(" ");
        zerar();
        lvl++;
        reiniciar();
        
        if(lvl==2){
            palavraAtual  = ClienteThread.agora.get(1).getPalavra();
            dica.setText(ClienteThread.agora.get(1).getTema());
        }
        else if(lvl==3){
            palavraAtual  = ClienteThread.agora.get(2).getPalavra();
            dica.setText(ClienteThread.agora.get(2).getTema());
        }
        else if(lvl==4){
            palavraAtual  = ClienteThread.agora.get(3).getPalavra();
            dica.setText(ClienteThread.agora.get(3).getTema());
        }
        pontuacaoG.setText("Pontuação Geral:"+geralPontuacao);
        System.out.println(geralPontuacao);
        }
    }
    
    //zera a pontuacão atual da rodada.
    private void zerar(){
        pontuacaoAtual = 0;
    }
    
    /*
    Indicar a letra para a palavra
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //A variavel pronto, é true quando o jagodor ja tenha realizado o sorteio,
        //e podera indicar a palavra.
        if(pronto){
            vzs = 0;
            if(lLetra.getText().length() == 1 && !letras.getText().contains(lLetra.getText())){
                indexar(palavraAtual, 0);
            if(!letras.getText().contains(lLetra.getText()))
                letras.setText(letras.getText()+"-"+lLetra.getText());
                        String x=letras.getText();
                        System.out.print("aque dentro :"+x);
               
            }
    
            if(sorteado == 0 || sorteado == 1)
                pontuacaoAtual = 0;
            else
                pontuacaoAtual = new Jogador().atualizarResultado(sorteado, vzs, pontuacaoAtual);
    
            if(verificar(lvl-1))
                try {
                    nextLvl();
                } catch (IOException ex) {
                    Logger.getLogger(TelaJogo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                Logger.getLogger(TelaJogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            pontuacao.setText("Pontuação Rodada:"+pontuacaoAtual);
    
            lLetra.setText("");
            pronto = false;
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ecomp/uefs/tela/roleta/roleta3.gif"))); // NOI18N
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //Realizar o Sorteio
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        //Novamente o pronto verificando se a jogada ja foi realizada,
        //se ele não realizou uma jogada possui a permição de realiza-lá.
        if(!pronto){
            sorteado = new Jogador().valor();
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ecomp/uefs/tela/roleta/"+sorteado+".png"))); // NOI18N
            if(sorteado == 0 || sorteado == 1){
                pronto = false;
                pontuacaoAtual = 0;
                pontuacao.setText("Pontuação :"+pontuacaoAtual);
                return;
            }
            pronto = true;
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    //Verifica se todas as letras foram preenchida para poder passar para a proxima rodada.
    private boolean verificar(int id){
        if(id == 0){
            if(!jLabel1.getText().equals("__") &&!jLabel2.getText().equals("__") &&!jLabel3.getText().equals("__") &&!jLabel4.getText().equals("__") &&!jLabel5.getText().equals("__")){
                return true;
            }
        }else if(id == 1){
            if(!jLabel1.getText().equals("__") &&!jLabel2.getText().equals("__") &&!jLabel3.getText().equals("__") &&!jLabel4.getText().equals("__") &&!jLabel5.getText().equals("__")
               && !jLabel6.getText().equals("__") && !jLabel7.getText().equals("__") ){
                return true;
            }
        }else if(id == 2){
            if(!jLabel1.getText().equals("__") &&!jLabel2.getText().equals("__") &&!jLabel3.getText().equals("__") &&!jLabel4.getText().equals("__") &&!jLabel5.getText().equals("__")
               && !jLabel6.getText().equals("__") && !jLabel7.getText().equals("__") 
               && !jLabel8.getText().equals("__") && !jLabel9.getText().equals("__") && !jLabel10.getText().equals("__")){
                return true;
            }
        }else{
            if(!jLabel1.getText().equals("__") &&!jLabel2.getText().equals("__") &&!jLabel3.getText().equals("__") &&!jLabel4.getText().equals("__") &&!jLabel5.getText().equals("__")
               && !jLabel6.getText().equals("__") && !jLabel7.getText().equals("__") 
               && !jLabel8.getText().equals("__") && !jLabel9.getText().equals("__") && !jLabel10.getText().equals("__")
               && !jLabel11.getText().equals("__") && !jLabel12.getText().equals("__") ){
                return true;
            }
        }
        return false;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dica;
    private javax.swing.JLabel inf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lLetra;
    private javax.swing.JLabel letras;
    private javax.swing.JLabel letras1;
    private javax.swing.JLabel pontuacao;
    private javax.swing.JLabel pontuacaoG;
    private javax.swing.JLabel rodada;
    // End of variables declaration//GEN-END:variables
}
