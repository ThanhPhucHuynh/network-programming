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
                

                String content = getContentFile(getFilePath(str));
                byte[] contentBytes = content.getBytes();
                socket.send(new DatagramPacket(contentBytes,contentBytes.length,packet.getAddress(),packet.getPort()));

            }
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("Exception : " + e.getMessage());
        }
    }
    public static String getFilePath(String fullInput) {
        return fullInput.split(" ")[fullInput.split(" ").length - 1];
    }
    public static String getContentFile(String path){
        String result = "";
        try {
            File file = new File(path);
            if(file.exists()){
                System.out.println(file.length());
                Scanner scanner = new Scanner(file);
                if(file.length()>4000) return "";
                while(scanner.hasNextLine()){
                    result+=scanner.nextLine()+'\n';
                }
            }
        } catch (IOException e) {
            System.out.println("Ex:io:  "+ e);
        }
        return result;
    }
    public static String getDateLocal(){
        LocalDate date = LocalDate.now();
        // System.out.println(date);
        return date.toString();
    }
}