
import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public interface Flightitf extends Remote{
    public String voidShow() throws RemoteException;
    public int getTotal() throws RemoteException;
    public void returnTicker() throws RemoteException;
    public void buyTicker() throws RemoteException;

}
