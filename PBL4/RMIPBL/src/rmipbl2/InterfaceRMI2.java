/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmipbl2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface que elenca todos os métodos que devem ser contidos no servidor RMI
 * 2
 *
 * @author Hugo Ribeiro e Washington Pagotto
 */
public interface InterfaceRMI2 extends Remote {

    public byte[] getPosicao() throws RemoteException;

    public String tretas() throws RemoteException;

    public boolean iniciaServidor() throws RemoteException;

}
