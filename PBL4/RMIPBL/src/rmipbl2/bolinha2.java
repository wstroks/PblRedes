/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 * CLasse responsável pela criação e pelo gerenciamento da interface gráfica do
 * Trem 1
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class bolinha2 extends JFrame {

    private int inicia;
    public JLabel bolinha2;
    public static JLabel bolinha1;
    public static JLabel bolinha3;
    private trilho t;

    public bolinha2(int x) throws InterruptedException {
        bolinha2 = new JLabel(new ImageIcon(getClass().getResource("bolinha2.png")));
        bolinha1 = new JLabel(new ImageIcon(getClass().getResource("bolinha1.png")));
        bolinha3 = new JLabel(new ImageIcon(getClass().getResource("bolinha3.png")));
        setTitle("servidor 1");
        t = new trilho();

        add(bolinha2);
        add(bolinha1);
        add(bolinha3);
        add(t.trilho);

        bolinha2.setBounds(95, 220, 50, 50);
        bolinha1.setBounds(270, 47, 50, 50);
        bolinha3.setBounds(443, 220, 50, 50);

        inicia = x;

        add(t.trilho);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        new bolinhaStart(inicia).start();
    }

    /**
     * Classe responsável por criar e gerenciar uma Thread que ficara
     * responsável por dar movimento aos trens
     */
    public class bolinhaStart extends Thread {

        int start;

        public bolinhaStart(int p) {
            start = p;
        }

        /**
         * Método run da Thread
         *
         * @throws InterruptedException
         */
        @Override
        public void run() {
            if (start == 2) {
                while (true) {

                    try {
                        //movimento da bolinha 2
                        sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(bolinha2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (bolinha2.getX() <= 440 && bolinha2.getY() == 220) {
                        // System.out.println("X:"+bolinha2.getX() +" Y:"+ bolinha2.getY());
                        bolinha2.setLocation(bolinha2.getX() + 2, bolinha2.getY());
                    } else if (bolinha2.getX() > 440 && bolinha2.getY() < 562) {
                        bolinha2.setLocation(bolinha2.getX(), bolinha2.getY() + 2);
                    } else if (bolinha2.getX() != 95 && bolinha2.getY() == 562) {
                        bolinha2.setLocation(bolinha2.getX() - 2, bolinha2.getY());
                    } else {
                        bolinha2.setLocation(bolinha2.getX(), bolinha2.getY() - 2);
                    }

                    if (bolinha3.getX() <= 792 && bolinha3.getY() == 220) {

                        bolinha3.setLocation(bolinha3.getX() + 2, bolinha3.getY());

                    } else if (bolinha3.getX() >= 792 && bolinha3.getY() <= 562) {
                        bolinha3.setLocation(bolinha3.getX(), bolinha3.getY() + 2);

                    } else if (bolinha3.getY() >= 562 && bolinha3.getX() >= 449) {
                        bolinha3.setLocation(bolinha3.getX() - 2, bolinha3.getY());
                        //System.out.println("BOLINHA3: "+bolinha3.getX()+"-"+bolinha3.getY());

                    } else {
                        bolinha3.setLocation(bolinha3.getX(), bolinha3.getY() - 2);
                    }

                    if (bolinha1.getX() <= 616 && bolinha1.getY() == 47) {
                        //movimento na linha A
                        //System.out.println("X:"+bolinha1.getX() +" Y:"+ bolinha1.getY());
                        bolinha1.setLocation(bolinha1.getX() + 2, bolinha1.getY());
                    } else if (bolinha1.getX() > 616 && bolinha1.getY() < 218) {
                        //movimento na linha B
                        // System.out.println("X:"+bolinha1.getX() +" Y:"+ bolinha1.getY());
                        bolinha1.setLocation(bolinha1.getX(), bolinha1.getY() + 2);
                    } else if (bolinha1.getX() != 270 && bolinha1.getY() == 219) {
                        //movimento na linha C
                        // System.out.println("X:"+bolinha1.getX() +" Y:"+ bolinha1.getY());
                        bolinha1.setLocation(bolinha1.getX() - 2, bolinha1.getY());
                    } else {
                        //movimento na linha D
                        //System.out.println("X:"+bolinha1.getX() +" Y:"+ bolinha1.getY());
                        bolinha1.setLocation(bolinha1.getX(), bolinha1.getY() - 2);
                    }//System.out.println(bolinha1.getX()+"-"+bolinha1.getY());
                }
            }
        }
    }

    /**
     * Muda a visibilidade da classe bolinha3 que gerencia o terceiro trem. A
     * visibilidade é setada pra false ou seja, o étodo é invocado sempre que o
     * servidor se desconectar
     */
    public static void SetVisibleB3() {
        bolinha3.setVisible(false);
    }

    /**
     * Muda a visibilidade da classe bolinha1 que gerencia o segundo trem. A
     * visibilidade é setada pra false ou seja, o étodo é invocado sempre que o
     * servidor se desconectar
     */
    public static void SetVisibleB1() {
        bolinha1.setVisible(false);
    }

    /**
     * Método Main que inicia o primeiro trem. Esse é ponto de início do trem em
     * questão
     *
     * @param args
     * @throws InterruptedException
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws InterruptedException, RemoteException, MalformedURLException, NotBoundException {
        CLienteRMI rmi = new CLienteRMI();
        rmi.iniciar();
        new bolinha2(2);
        while (true) {
            boolean f3 = rmi.fluxo3();
            boolean f2 = rmi.fluxo2();
            if (f3 == false) {
                SetVisibleB3();
            }
            if (f2 == false) {
                SetVisibleB1();
            }
        }

    }

}
