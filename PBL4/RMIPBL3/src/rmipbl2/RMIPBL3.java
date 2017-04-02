/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Classe Responsável por gerenciar o servidor RMI nele, todos os métodos
 * listados na interface genérica são implementados além disso, ela é
 * responsável por gerar o servidor RMI.
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public class RMIPBL3 extends UnicastRemoteObject implements InterfaceRMI3 {

    /**
     * @param args the command line arguments
     */
    private cript criptar;
    private String PosicaoAtual;

    public RMIPBL3() throws InterruptedException, RemoteException {
        super();
        criptar = new cript();

    }

    public void setPosicaoAtual(String pos) {
        PosicaoAtual = pos;
    }

    /**
     * Inicia o servidor RMI
     *
     * @return boolean que indica se o servidor foi inicializado
     * @throws RemoteException erro de conexão com o RMI
     */
    @Override
    public boolean iniciaServidor() throws RemoteException {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Indica a posição do RMI, Se ativo ou inativo
     *
     * @return indica a posição de disponibilidade do servidor
     * @throws RemoteException erro de conexão com o RMI
     */
    @Override
    public byte[] getPosicao() throws RemoteException {
        return criptar.encripta("Ativo");

    }

    /**
     * Método que não é utizado. Mas, por problemas no RMI. Ter que ficar a todo
     * momento criando stump, colocamos esse método para caso de necessidade
     *
     * @return
     * @throws RemoteException erro de conexão com o RMI
     */
    @Override
    public String tretas() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
