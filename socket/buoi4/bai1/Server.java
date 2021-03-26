import java.util.*;
import java.io.*;
import java.net.*;

public class Server{

    public final static int defaultPort = 7;

    public static void main(String[] args){
        System.out.println("Hello I'm a server");
        
        try {
            
            ServerSocket server_socket = new ServerSocket(defaultPort);
            while (true) {
                Socket socket = server_socket.accept();
                Processing processing = new Processing(socket);
                processing.start();
            }
        } catch (IOException e) {
            System.out.println("Err"+e);
        }
    }
}
