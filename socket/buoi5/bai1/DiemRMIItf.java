import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public interface DiemRMIItf extends Remote {
    public String voidShow() throws RemoteException;
    public void setXY(int x, int y) throws RemoteException;
    public void ChangeXY(int x, int y) throws RemoteException;
}