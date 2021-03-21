import java.util.*;
import java.net.*;
import java.io.*;
import java.time.*;
public class Server{
    public final static int defaultPort = 7;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(7);
            System.out.println("Create successfully server...");
            byte[] buffer = new byte[60000];
            while(true) {
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);

                String str = new String(packet.getData(),0,packet.getLength());

                

                DatagramPacket out = new DatagramPacket(str.getBytes(),packet.getLength(),packet.getAddress(),packet.getPort());
                String date = getDateLocal();
                byte[] dateBytes = date.getBytes();
                socket.send(new DatagramPacket(dateBytes,dateBytes.length,packet.getAddress(),packet.getPort()));

            }
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("Exception : " + e.getMessage());
        }
    }
    public static String getDateLocal(){
        LocalDate date = LocalDate.now();
        // System.out.println(date);
        return date.toString();
    }
}