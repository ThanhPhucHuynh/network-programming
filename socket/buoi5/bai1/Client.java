import java.util.*;
import java.net.*;
import java.io.*;
import java.rmi.*;
import java.net.MalformedURLException.*;


public class Client{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            DiemRMIItf refA = (DiemRMIItf) Naming.lookup("rmi://localhost/ShowDiemA");
            DiemRMIItf refB = (DiemRMIItf) Naming.lookup("rmi://localhost/ShowDiemB");
            DiemRMIItf refC = (DiemRMIItf) Naming.lookup("rmi://localhost/ShowDiemC");


            while(true){
                System.out.println("Your choose: \n 1. show point\n 2. Set point \n");
                int youChoose = scanner.nextInt();
                switch (youChoose) {
                    case 1:
                        System.out.println("A: "+refA.voidShow());
                        System.out.println("B: "+refB.voidShow());
                        System.out.println("C: "+refC.voidShow());
                        break;
                
                    default:
                        System.out.println("Your choose point: \n 1. A\n 2. B \n 3. C\n");
                        int youChoosePoint = scanner.nextInt();
                        int X,Y;
                        System.out.println("X: ");X=scanner.nextInt();
                        System.out.println("Y: ");Y=scanner.nextInt();
                        switch (youChoosePoint) {
                            case 1:
                                refA.setXY(X,Y);
                                break;
                            case 2:
                                refB.setXY(X,Y);
                                break;
                            case 3:
                                refC.setXY(X,Y);
                                break;
                            default:
                                break;
                        }
                        break;
                }
            }

            // String result = ref.voidShow();
             
            // System.out.println("Diem: "+result);
            // ref.setXY(5,6);
            // System.out.println("Diem: "+result);
            // result = ref.voidShow();
            // System.out.println("Diem: "+result);
            
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