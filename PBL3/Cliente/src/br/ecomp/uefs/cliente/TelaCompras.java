/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ecomp.uefs.cliente;

import static br.ecomp.uefs.cliente.ClienteServidores.enviarSV;
import static br.ecomp.uefs.cliente.ClienteServidores.manolo;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author wstro
 */
public class TelaCompras extends javax.swing.JFrame {

    /**
     * Creates new form TelaCompras
     */
    private  double valortotal;
    private double valorlivro;
    private int qtdLivro;
    private int novaqtd;
    private String atualizar;
    private  LinkedList<LinkedList<String>> atualizarlista;
    private LinkedList<LinkedList<String>> atualizarAxu;
    private LinkedList<LinkedList<String>> aux;
    private LinkedList<LinkedList<String>> c;
    private int valorEnviar;
    private String nome;
    
    public TelaCompras() {
        initComponents();
         
        
        
    }
    
    public void iniciar(){
        Listar.setVisible(true);
        atualizarlista= new LinkedList<LinkedList<String>>();
         atualizarAxu= new LinkedList<LinkedList<String>>();
         aux= new LinkedList<LinkedList<String>>();
         c= new LinkedList<LinkedList<String>>();
         atualizarlista=manolo;
         c=manolo;
        valortotal=0;
         
    }
    public void atualizar(){
        int contador =0;
        Iterator at= atualizarlista.iterator();
        
        while(at.hasNext()){
            LinkedList<LinkedList<String>> o=(LinkedList<LinkedList<String>>) at.next();
                 LinkedList x= new LinkedList();
                x.add(o.get(0));
                String a= (String)x.get(0);
                
                     
                      if(Listar.getSelectedItem().equals(a)){
                          int vaicomprar=Integer.parseInt(qtd.getText());
                          System.out.println("vou comprar" +vaicomprar);
                          int atual=qtdLivro;
                          System.out.println("autal Livro qtd" +atual);
                          if(atual>=vaicomprar){
                          int muda=atual-vaicomprar;
                           System.out.println("calculo" +muda);
                          String ha= String.valueOf(muda);
                          
                          System.out.println(muda);
                           System.out.println("envia esse demo"+ha);
                          
                           
                         atualizarlista.get(contador).set(2, ha);
                        System.out.println(atualizarlista.get(contador));
                        atualizarAxu=atualizarlista;
                                 }                       
                        
            
                }
                       contador++;
        
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        toral = new javax.swing.JTextField();
        Listar = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        qtd = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        t = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        OKVALOR = new javax.swing.JButton();
        mano = new javax.swing.JLabel();
        finalizar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        toral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toralActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Listar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "O nome do vento", "Artur", "Manopla", "O temor do sabio", "Cinquentinha ninja" }));
        Listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar Compra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor compra Total");

        jLabel2.setText("Quantidade");

        jLabel3.setText("Disponivel");

        jLabel6.setText("Valor Livro");

        OKVALOR.setText("OK");
        OKVALOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OKVALORActionPerformed(evt);
            }
        });

        finalizar.setText("Finalizar Compra");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar Compra");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(Listar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(finalizar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(OKVALOR)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mano, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(t, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Listar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(OKVALOR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mano, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finalizar)
                    .addComponent(jButton2))
                .addGap(19, 19, 19)
                .addComponent(t)
                .addGap(162, 162, 162))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ListarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
        try {
            boolean controle= false;
                   int contador =0;
        int controla=0;
            ClienteServidores.enviarSV.writeUTF("aque");
            System.out.println("auq");
            aux=manolo;
                for(int x=0; x<aux.size(); x++){
                    System.out.println("tamnhao aux"+aux.size());
                String velho1=aux.get(x).get(0);
                 String velho2=aux.get(x).get(1);
                  String velho3=aux.get(x).get(2);
                for(int y=0; y<c.size(); y++){
                    System.out.println("tamnhao aux"+manolo.size());
                    String compara1=c.get(y).get(0);
                    String compara2=c.get(y).get(1);
                    String compara3=c.get(y).get(2);
                    if(velho1.equals(compara1) && velho2.equals(compara2) &&velho3.equals(compara3) ){
                        System.out.println(" 1:"+compara1);
                         System.out.println("2:"+compara2);
                        controla++;
                    }
                }
            }
        System.out.println("numero "+controla);
        
        
       if(controla>0){
          System.out.println("ninguem atualizou ");
          atualizarlista=aux;
       }
       else{
             
            // atualizarlista=aux;
       }
       
       
        Iterator at= atualizarlista.iterator();
        while(at.hasNext()){
            LinkedList<LinkedList<String>> ap = new LinkedList<LinkedList<String>>();
        ap=(LinkedList<LinkedList<String>>) at.next();
                     
                     LinkedList vc = new LinkedList();
                     
                     vc.add(ap.get(0));
                     vc.add(ap.get(1));
                     vc.add(ap.get(2));
                     
                     String no=(String) vc.get(0);
                     String agi= (String) vc.get(1);
                     String baba= (String) vc.get(2);
                    
                  if(Listar.getSelectedItem().equals(no)){
                      System.out.println("aque1"+agi);
                      System.out.println("aque1"+baba);
                      jLabel7.setText(agi);
                      jLabel5.setText(baba);
                      atualizar=nome;
                      
                       valorlivro=Double.parseDouble((String) vc.get(1));
                       qtdLivro= Integer.parseInt((String) vc.get(2));
                  }
                }
        } catch (IOException ex) {
            Logger.getLogger(TelaCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void toralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_toralActionPerformed

    private void OKVALORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OKVALORActionPerformed
        // TODO add your handling code here:
        
        //System.out.println(agora);
        String quantidade = qtd.getText();
        if(!quantidade.equals("")){
            int agora=Integer.parseInt(qtd.getText());
        if(agora<=qtdLivro){
            
            valortotal+=valorlivro*agora;
            String b= String.valueOf(valortotal);
                      
            mano.setText(b);
            atualizar();
        }
        else{
            JOptionPane.showMessageDialog(null, " não tem mais livro !!!");
            
        }
    }//GEN-LAST:event_OKVALORActionPerformed
        else{
            JOptionPane.showMessageDialog(null, " Digite a quantidade que deseja comprar !!!");
        }
    
    
    
    }
    
    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        // TODO add your handling code here:
       
        try {
            String nomeDoComprador=JOptionPane.showInputDialog("Digite seu login:");
            if(!nomeDoComprador.equals("")){
             System.out.println(atualizar);
             enviarSV.writeUTF("finalizar");
             enviarSV.writeDouble(valortotal);
             enviarSV.writeUTF(nomeDoComprador);
             //enviarSV.writeUTF("txt");
             ClienteServidores.enviarSV.writeUTF("terminando");
             ClienteServidores.enviarSV.writeInt(atualizarlista.size());
             for(int x=0; x<atualizarlista.size(); x++){
                 System.out.println(atualizarlista.get(x).get(0));
                 if(atualizarlista.get(x)==null){
                     atualizarAxu.remove(x);
                 }
                 else{
                 ClienteServidores.enviarSV.writeUTF(atualizarlista.get(x).get(0));
                 ClienteServidores.enviarSV.writeUTF(atualizarlista.get(x).get(1));
                 ClienteServidores.enviarSV.writeUTF(atualizarlista.get(x).get(2));
                 }
             }
                
             Cliente cliente= new Cliente();
             cliente.show();
             this.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Finalize compra novamente e digite seu login");
            }
        } catch (IOException ex) {
            Logger.getLogger(TelaCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_finalizarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            
        try {
            enviarSV.writeUTF("txt");
           Cliente cliente = new Cliente();
           cliente.voltar();
            cliente.show();
             this.setVisible(false);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaCompras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TelaCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Listar;
    private javax.swing.JButton OKVALOR;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mano;
    private javax.swing.JTextField qtd;
    private javax.swing.JLabel t;
    private javax.swing.JTextField toral;
    // End of variables declaration//GEN-END:variables
}
