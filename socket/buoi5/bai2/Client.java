import java.util.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.net.MalformedURLException.*;


public class Client{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {

            Flightitf temp = (Flightitf) Naming.lookup("rmi://localhost/ShowInfo1");
            int numberFlights = temp.getTotal();
            System.out.println("numberFlights: " + numberFlights);
            
            ArrayList<Flightitf> listFlight = new ArrayList<Flightitf>();
            
            for (int i = 1; i <= numberFlights; i++) {
                listFlight.add((Flightitf) Naming.lookup("rmi://localhost/ShowInfo"+i));
            }
            for (int i = 0; i < numberFlights; i++) {
                System.out.println("Diem: "+listFlight.get(i).voidShow());
            }
            
            while(true){
                System.out.println("1. Buy Ticker"+"\n2. Return Ticker \n 3. Show");
                int youChoose = scanner.nextInt();
                // int youChoose = scanner.nextInt();
                System.out.println("Number flight: ");
                int youChooseFlight = scanner.nextInt();
                switch(youChoose){
                    case 1:
                        listFlight.get(youChooseFlight-1).buyTicker();
                        break;
                    case 2:
                        listFlight.get(youChooseFlight-1).returnTicker();
                        break;
                    case 3:
                        for (int i = 0; i < numberFlights; i++) {
                            System.out.println("Diem: "+listFlight.get(i).voidShow());
                        }
                        break;
                    default:
                        break;
                }
            }
            
            
            
        } catch (NotBoundException e) {
            //TODO: handle exception
            System.out.println("NotBoundException : " + e.getMessage());
        }catch (MalformedURLException e) {
            //TODO: handle exception
            System.out.println("MalformedURLException : " + e.getMessage());
        }catch(RemoteException e){
            System.out.println("RemoteException : " + e.getMessage());

        }
    }

}