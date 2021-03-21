import java.util.*;
import java.net.*;
import java.io.*;

public class Client{
    public final static int defaultPort = 7;
    public static void main(String[] args) {
        try {
            if(args.length == 0) {return;}
            System.out.println("Create complete client... ");
            DatagramSocket socket = new DatagramSocket();

            InetAddress address = InetAddress.getByName(args[0]);
            while(true) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String theString = reader.readLine();
                byte[] data = theString.getBytes();

                DatagramPacket packet = new DatagramPacket(data,data.length,address,defaultPort);
                socket.send(packet);

                byte[] buffer = new byte[6000];

                DatagramPacket packetIncoming = new DatagramPacket(buffer,buffer.length);
                socket.receive(packetIncoming);
                System.out.println(new String(packetIncoming.getData(),0,packetIncoming.getLength()));
            }

    
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("Exception : " + e.getMessage());
        }
    }
}