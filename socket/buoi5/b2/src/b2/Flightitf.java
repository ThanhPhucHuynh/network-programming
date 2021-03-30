/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b2;
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author tphuc
 */
public interface Flightitf extends Remote{
            public String voidShow() throws RemoteException;

}
