package rmipbl2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe responsável por gerenciar todos os clientes RMI de mum determinado
 * servidor. Exemplo, o servidor um se conecta aos servidores dois e três. Essas
 * conexões estão mantidas nessa classe que nesse caso, gerencia as conexões do
 * servidor um
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class CLienteRMI {

    public static RMIPBL rmi;
    public static InterfaceRMI2 rmi2;
    public static InterfaceRMI3 rmi3;
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
     * @throws NotBoundException
     */
    public boolean iniciar() throws RemoteException, InterruptedException, MalformedURLException, NotBoundException {

        rmi = new RMIPBL();

        java.rmi.registry.LocateRegistry.createRegistry(1020);

        Naming.rebind("rmi://localhost:1020/myabc", rmi);

        //rmi2 = (InterfaceRMI2) Naming.lookup("rmi://localhost:1010/myabc");
        while (true) {
            try {

                System.out.println(rmi2.iniciaServidor());
                System.out.println(rmi3.iniciaServidor());
                return true;
            } catch (RemoteException | NullPointerException e) {

                conectarserv2();
                conectarserv3();

            }
        }

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
            byte[] criptado = rmi2.getPosicao();
            cripta = new cript();
            System.out.println(new String(criptado));
            System.out.println(cripta.decripta(criptado));
            return true;
        } catch (Exception ex) {

            System.out.println("Servidor 2 não conectou");
        }
        return false;
    }

    /**
     * * Classe que faz a conexão com o servidor 3. Aqui é usada a criptografia
     * para ver se realmente o servidor está enviando as mensagens corretas
     *
     * @return true caso a conexão seja efetuada com sucesso
     */
    public boolean conectarserv3() {
        try {
            rmi3 = (InterfaceRMI3) Naming.lookup("rmi://localhost:1030/myabc");
            byte[] criptado = rmi3.getPosicao();
            cripta = new cript();
            System.out.println(new String(criptado));
            System.out.println(cripta.decripta(criptado));
            return true;
        } catch (Exception ex) {
            System.out.println("Servidor 3 não conectou");
        }
        return false;
    }

    public boolean fluxo3() throws InterruptedException, RemoteException {

        try {
            rmi3 = (InterfaceRMI3) Naming.lookup("rmi://localhost:1030/myabc");
            return true;
        } catch (Exception ex) {
            System.out.println("Servidor 3 não conectou");
            return false;
        }

    }

    public boolean fluxo2() throws InterruptedException, RemoteException {

        try {
            rmi2 = (InterfaceRMI2) Naming.lookup("rmi://localhost:1010/myabc");
            return true;
        } catch (Exception ex) {

            System.out.println("Servidor 2 não conectou");
            return false;
        }

    }
}
