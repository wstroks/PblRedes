/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Classe responsável por gerenciar todos os clientes RMI de mum determinado
 * servidor. Exemplo, o servidor um se conecta aos servidores dois e três. Essas
 * conexões estão mantidas nessa classe que nesse caso, gerencia as conexões do
 * servidor um
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class CLienteRMI3 {

    private static InterfaceRMI rmi;
    private static InterfaceRMI2 rmi2;
    private static RMIPBL3 rmi3;
    private cript cripta;

  
    /**
     * Método responsável por iniciar os fluxos de conexão, ele fica testando
     * até que as conexões estejam ativas e só assim, permitir que a classe
     * bolinha onde se encontra o método main possa inicializar a interface
     *
     * @return true caso as conexões sejam realizadas
     * @throws RemoteException
     * @throws InterruptedException
     * @throws MalformedURLException
     */
    public boolean iniciar() throws InterruptedException, RemoteException, MalformedURLException {

        rmi3 = new RMIPBL3();

        java.rmi.registry.LocateRegistry.createRegistry(1030);

        Naming.rebind("rmi://localhost:1030/myabc", rmi3);

        //rmi2 = (InterfaceRMI2) Naming.lookup("rmi://localhost:1010/myabc");
        while (true) {
            try {

                System.out.println(rmi2.iniciaServidor());
                System.out.println(rmi.iniciaServidor());
                return true;
            } catch (RemoteException | NullPointerException e) {

                conectarserv2();
                conectarserv1();

            }
        }

    }
    
     /**
     * Classe que faz a conexão com o servidor 1.Aqui é usada a criptografia
     * para ver se realmente o servidor está enviando as mensagens corretas
     *
     * @return true caso a conexão seja efetuada com sucesso
     */

    public boolean conectarserv1() {
        try {
            rmi = (InterfaceRMI) Naming.lookup("rmi://localhost:1020/myabc");
            byte[]criptado = rmi.getPosicao();
            cripta = new cript();
            System.out.println(new String (criptado));
            System.out.println(cripta.decripta(criptado));
            return true;
        } catch (Exception ex) {

            System.out.println("Servidor 1 não conectou");
        }
        return false;
    }
    
     /**
     * Classe que faz a conexão com o servidor 2.Aqui é usada a criptografia
     * para ver se realmente o servidor está enviando as mensagens corretas
     *
     * @return true caso a conexão seja efetuada com sucesso
     */

    public boolean conectarserv2() {
        try {
            rmi2 = (InterfaceRMI2) Naming.lookup("rmi://localhost:1010/myabc");
            byte[]criptado = rmi2.getPosicao();
            cripta = new cript();
            System.out.println(new String (criptado));
            System.out.println(cripta.decripta(criptado));
            return true;
        } catch (Exception ex) {
            System.out.println("Servidor 2 não conectou");
        }
        return false;
    }

    public boolean fluxo2() throws RemoteException, InterruptedException {
       
        try {
            rmi2 = (InterfaceRMI2) Naming.lookup("rmi://localhost:1010/myabc");
            return true;
        } catch (Exception ex) {
            System.out.println("Servidor 2 não conectou");
            return false;
        }
    }
    
    public boolean fluxo() throws RemoteException, InterruptedException {
       
       try {
           
            rmi = (InterfaceRMI) Naming.lookup("rmi://localhost:1020/myabc");
            return true;
        } catch (Exception ex) {

            System.out.println("Servidor 1 não conectou");
            return false;
        }
    }
    
}
