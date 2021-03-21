import java.io.*;
import java.net.*;
import java.util.*;

public class Server extends Thread {
    public final static int portServer  =7;
    public final static int numberBuffers =60000;

    private DatagramSocket socket;
    private ArrayList<InetAddress> listClientAddresses;
    private ArrayList<String> listClientNames;
    private ArrayList<Integer> listClientPorts;
    private HashSet<String> existingClients;
    public Server() throws IOException {
        this.socket = new DatagramSocket(portServer);
        this.listClientAddresses = new ArrayList();
        this.listClientPorts = new ArrayList();
        this.listClientNames = new ArrayList();
        this.existingClients = new HashSet();
    }
    public void run(){
        byte[] bytesBuf = new byte[numberBuffers];
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(bytesBuf, bytesBuf.length);
                socket.receive(packet);
                
                // String content = new String(bytesBuf, bytesBuf.length);
                String content = new String(packet.getData(),0,packet.getLength());
               
                InetAddress clientAddress = packet.getAddress();
                int clientPort = packet.getPort();
                
                String id = clientAddress.toString() + "," + clientPort;
                if (!existingClients.contains(id)) {
                    existingClients.add(id);
                    listClientPorts.add(clientPort);
                    listClientAddresses.add(clientAddress);
                }
                
                System.out.println(id + " : " + content);
                byte[] data = (id + " : " +  content).getBytes();
                
                for (int i=0; i < listClientAddresses.size(); i++) {
                    InetAddress clientAddressInList = listClientAddresses.get(i);
                    int clientPortInList = listClientPorts.get(i);
                    packet = new DatagramPacket(data, data.length, clientAddressInList, clientPortInList);
                    socket.send(packet);
                }
            } catch (IOException e) {
                //TODO: handle exception
                System.err.println(e);
            }
        }
    }
    public static void main(String args[]) throws Exception {
        Server s = new Server();
        s.start();
    }
 
}