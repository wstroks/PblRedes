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
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;

/**
 * CLasse responsável pela criação e pelo gerenciamento da interface gráfica do
 * Trem 2
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class bolinha1 extends JFrame {

    private int ate;
    public JLabel bolinha1;
    public static JLabel bolinha2;
    public static JLabel bolinha3;

    private trilho t;

    public bolinha1(int a) {
        bolinha1 = new JLabel(new ImageIcon(getClass().getResource("bolinha1.png")));
        bolinha2 = new JLabel(new ImageIcon(getClass().getResource("bolinha2.png")));
        bolinha3 = new JLabel(new ImageIcon(getClass().getResource("bolinha3.png")));
        setTitle("servidor 2");

        bolinha1.setBounds(270, 47, 50, 50);
        bolinha2.setBounds(95, 220, 50, 50);
        bolinha3.setBounds(443, 220, 50, 50);

        ate = a;
        t = new trilho();

        add(bolinha1);
        add(bolinha2);
        add(bolinha3);

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

        public void run() {

            while (true) {
                if (vai == 1) {
                    try {
                        sleep(20);
                        /*            A
                         * 	 ____________________
                         * 	 |					 |
                         * 	 |					 |
                         * D |					 | B
                         * 	 |					 |
                         * 	 |___________________|
                         * 		      c
                         * */

                        //movimento da bolinha 1
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

                        //movimento da bolinha 2
                        if (bolinha2.getX() <= 440 && bolinha2.getY() == 220) {
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
                            System.out.println("BOLINHA3: " + bolinha3.getX() + "-" + bolinha3.getY());

                        } else {
                            bolinha3.setLocation(bolinha3.getX(), bolinha3.getY() - 2);
                        }
                        /*else if(bolinha3.getX()<440 && bolinha3.getY()>562){
                         bolinha3.setLocation(bolinha3.getX(), bolinha3.getY()+2);
                         }else if(bolinha2.getX()!=443 && bolinha2.getY()==562){
                         bolinha3.setLocation(bolinha3.getX()-2, bolinha3.getY());
                         } else {
                         bolinha3.setLocation(bolinha3.getX(), bolinha3.getY()-2);
                         }*/
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
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
     * Método Main que inicia o segundo trem. Esse é ponto de início do trem em
     * questão
     *
     * @param args
     * @throws InterruptedException
     * @throws RemoteException
     * @throws MalformedURLException
     * @throws NotBoundException
     */

    public static void main(String[] args) throws InterruptedException, RemoteException, MalformedURLException, NotBoundException {
        ClienteRMI2 rmi2 = new ClienteRMI2();
        rmi2.iniciar();
        new bolinha1(1);
        System.out.println("passou");
        while (true) {
            boolean f1 = rmi2.fluxo();
            boolean f3 = rmi2.fluxo3();
            if (f1 == false) {
                SetVisibleB2();
            }
            if (f3 == false) {
                SetVisibleB3();
            }
        }

    }

}
