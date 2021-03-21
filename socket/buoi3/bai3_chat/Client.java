import java.io.*;
import java.net.*;
import java.util.*;


class MessageSender implements Runnable {
    public final static int PORT = 7;
    private DatagramSocket sock;
    private String hostname;
    private String name;

    MessageSender(DatagramSocket s, String h,String name) {
        sock = s;
        hostname = h;
        this.name = name;
    }
    private void sendMessage(String s) throws Exception {

        byte buf[] = (name+": "+ s).getBytes();
        InetAddress address = InetAddress.getByName(hostname);
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, PORT);
        sock.send(packet);
    }
    public void run() {
        
        boolean connected = false;
        do {
            try {
                sendMessage("GREETINGS");
                connected = true;
            } catch (Exception e) {
                
            }
        } while (!connected);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
       

        while (true) {
            

            try {
                // while (!in.ready()) {
                //     Thread.sleep(100);
                // }
                
                
                String content = in.readLine();
                sendMessage(content);
            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}
class MessageReceiver implements Runnable {
    DatagramSocket sock;
    byte buf[];
    MessageReceiver(DatagramSocket s) {
        sock = s;
        buf = new byte[1024];
    }
    public void run() {
        while (true) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                sock.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println(received);
                System.out.print("type content -->" );

            } catch(Exception e) {
                System.err.println(e);
            }
        }
    }
}
public class Client {
    
    public static void main(String args[]) throws Exception {
        System.out.print("Name:? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.print("\n");
        String host = null;
        if (args.length < 1) {
            System.out.println("Usage: java ChatClient <server_hostname>");
            System.exit(0);
        } else {
            host = args[0];
        }
        DatagramSocket socket = new DatagramSocket();
        MessageReceiver r = new MessageReceiver(socket);
        MessageSender s = new MessageSender(socket, host,name);
        Thread rt = new Thread(r);
        Thread st = new Thread(s);
        rt.start(); st.start();
    }
}