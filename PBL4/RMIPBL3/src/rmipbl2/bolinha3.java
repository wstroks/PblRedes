/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import static java.lang.Thread.sleep;
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
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 * CLasse responsável pela criação e pelo gerenciamento da interface gráfica do
 * Trem 3
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class bolinha3 extends JFrame {

    private int dois;
    public JLabel bolinha3;
    public static JLabel bolinha1;
    public static JLabel bolinha2;
    public static boolean queda1;
    public static boolean queda2;
    private trilho t;

    public bolinha3(int a) throws InterruptedException {
        queda1 = false;
        queda2 = false;
        bolinha1 = new JLabel(new ImageIcon(getClass().getResource("bolinha1.png")));
        bolinha2 = new JLabel(new ImageIcon(getClass().getResource("bolinha2.png")));

        bolinha3 = new JLabel(new ImageIcon(getClass().getResource("bolinha3.png")));
        t = new trilho();

        setTitle("servidor 3");

        bolinha1.setBounds(270, 47, 50, 50);
        bolinha2.setBounds(95, 220, 50, 50);
        bolinha3.setBounds(443, 220, 50, 50);

        dois = a;

        add(bolinha3);
        add(bolinha1);
        add(bolinha2);
        add(t.trilho);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(950, 700);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);
        new bolinhaStart(a).start();
    }

    /**
     * Classe responsável por criar e gerenciar uma Thread que ficara
     * responsável por dar movimento aos trens
     */
    public class bolinhaStart extends Thread {

        int vai;

        public bolinhaStart(int p) {
            vai = p;
        }

        @Override
        public void run() {
            if (vai == 3) {
                while (true) {

                    try {
                        sleep(20);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(bolinha3.class.getName()).log(Level.SEVERE, null, ex);
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
                    }

                }
            }
        }
    }

    /**
     * Muda a visibilidade da classe bolinha2 que gerencia o primeiro trem. A
     * visibilidade é setada pra false ou seja, o étodo é invocado sempre que o
     * servidor se desconectar
     */
    public static void SetVisibleB2() {
        bolinha2.setVisible(false);
        queda2 = true;

    }
    
    /**
     * Muda a visibilidade da classe bolinha1 que gerencia o segundo trem. A
     * visibilidade é setada pra false ou seja, o étodo é invocado sempre que o
     * servidor se desconectar
     */
    public static void SetVisibleB1() {
        bolinha1.setVisible(false);
        queda1 = true;
    }

    /**
     * Método Main que inicia o terceiro trem. Esse é ponto de início do trem em
     * questão
     *
     * @param args
     * @throws InterruptedException
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */
    public static void main(String[] args) throws InterruptedException, RemoteException, MalformedURLException, NotBoundException {
        CLienteRMI3 rmi3 = new CLienteRMI3();
        rmi3.iniciar();
        new bolinha3(3);
        while (true) {
            boolean f1 = rmi3.fluxo();
            boolean f2 = rmi3.fluxo2();
            if (f1 == false) {
                SetVisibleB2();
            }
            if (f1 == true) {
                bolinha2.setVisible(true);
            }
            if (f2 == false) {
                SetVisibleB1();
            }
        }
    }

}
