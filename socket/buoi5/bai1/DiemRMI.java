import java.rmi.RemoteException;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

public class DiemRMI extends UnicastRemoteObject implements DiemRMIItf {
    private int x;
    private int y;
    public DiemRMI()  throws RemoteException {
        super();
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void ChangeXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public String voidShow(){
        System.out.println("this is voidShow()");
        return ("X: "+this.x+"|| Y: "+this.y);
    }
}