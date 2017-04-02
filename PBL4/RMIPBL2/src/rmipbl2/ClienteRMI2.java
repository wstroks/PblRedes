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
public class ClienteRMI2 {

    private static InterfaceRMI rmi;
    private static RMIPBL2 rmi2;
    private static InterfaceRMI3 rmi3;
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

        rmi2 = new RMIPBL2();

        java.rmi.registry.LocateRegistry.createRegistry(1010);

        Naming.rebind("rmi://localhost:1010/myabc", rmi2);

        while (true) {
            try {

                System.out.println(rmi3.iniciaServidor());
                System.out.println(rmi.iniciaServidor());
                return true;
            } catch (RemoteException | NullPointerException e) {

                conectarserv1();
                conectarserv3();

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
            byte[] criptado = rmi.getPosicao();
            cripta = new cript();
            System.out.println(new String(criptado));
            System.out.println(cripta.decripta(criptado));
            return true;
        } catch (Exception ex) {

            System.out.println("Servidor 1 não conectou");
        }
        return false;
    }
    
    /**
     * Classe que faz a conexão com o servidor 3.Aqui é usada a criptografia
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

    public boolean fluxo() throws RemoteException {
        try {

            System.out.println(rmi.iniciaServidor());
            return true;
        } catch (RemoteException | NullPointerException e) {

            conectarserv1();
            return false;

        }
    }

    public boolean fluxo3() throws RemoteException {
        try {

            System.out.println(rmi3.iniciaServidor());
            return true;
        } catch (RemoteException | NullPointerException e) {

            conectarserv3();
            return false;

        }
    }

}
