import java.io.*;
import java.net.*;

public class Server{
    public static void main(String args[]){
       
        try {
            // System.out.println("HEllo World");
            ServerSocket  ss = new ServerSocket(7);
            Socket s = ss.accept();
            
            // DataInputStream dis=new DataInputStream(s.getInputStream());  
            // String  str=(String)dis.readUTF();  
            // System.out.println("message= "+str);  
            // ss.close();  

        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Something wrong!"+ie);
        }
    }
}