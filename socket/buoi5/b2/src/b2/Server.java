/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package b2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/**
 *
 * @author tphuc
 */
public class Server {
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
            
            Naming.rebind("ShowInfoA",new Flight());
            Naming.rebind("ShowInfoB",new Flight());

           
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
