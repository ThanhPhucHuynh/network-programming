
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
public class Server {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        // System.out.println("Created 3 points A B C with x,y (0,0)");
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            int numberFlights = 0;
            System.out.println("type number flight: "); 
            
            numberFlights = scanner.nextInt();
            System.out.println("Creating list flight...(2)");
            
            ArrayList<Flight> listFlight = new ArrayList<Flight>();
            for (int i = 0; i < numberFlights; i++) { 
                listFlight.add(new Flight(LocalDateTime.now(),"Can Tho -"+ i,"HCM "+i,2.5,30,numberFlights));
            }
            
            System.out.println("length list: "+listFlight.size());
            
            // Naming.rebind("num",numberFlights); 
            
            for (int i = 0; i < numberFlights; i++) { 
                System.out.println("ShowInfo"+listFlight.get(i).getId()+" was created!");
                Naming.rebind("ShowInfo"+listFlight.get(i).getId(),listFlight.get(i)); 
            }
            
            
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
