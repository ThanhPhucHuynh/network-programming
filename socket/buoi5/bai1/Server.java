import java.util.*;
import java.net.*;
import java.io.*;
import java.time.*;
import java.rmi.*;
public class Server{
    public final static int defaultPort = 7;
    Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // DiemRMI a = new DiemRMI();
        // DiemRMI b = new DiemRMI();
        // DiemRMI c = new DiemRMI();
        System.out.println("Created 3 points A B C with x,y (0,0)");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            // DiemRMI obj = new DiemRMI();
            System.out.println("Create A: (0, 0)");
            DiemRMI a = new DiemRMI();
            System.out.println("Create B: (0, 0)");
            DiemRMI b = new DiemRMI();
            System.out.println("Create C: (0, 0)");
            DiemRMI c = new DiemRMI();
            Naming.rebind("ShowDiemA",a);
            Naming.rebind("ShowDiemB",b);
            Naming.rebind("ShowDiemC",c);

            // Naming.rebind("SetDiemA",new DiemRMI());
            System.out.println("Complete...\n waiting client...");

        } catch (RemoteException e) {
            //TODO: handle exception
            System.out.println("Exception : " + e.getMessage());
        }catch (MalformedURLException e) {
            //TODO: handle exception
            System.out.println("MalformedURLException : " + e.getMessage());
        }
    }
}