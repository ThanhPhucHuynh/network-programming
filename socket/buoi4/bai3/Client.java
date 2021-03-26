
import java.util.*;
import java.io.*;
import java.net.*;

public class Client {
    private static final int PIECES_OF_FILE_SIZE = 1024 * 32;
    private MulticastSocket clientSocket;
    private int serverPort = 7;
    private String serverHost = "127.0.0.1";

    private void connectServer() throws IOException{
       
            clientSocket = new MulticastSocket(serverPort);
            InetAddress inetAddress = InetAddress.getByName("225.1.1.1");
            clientSocket.joinGroup(inetAddress);
            while (true) {
                // System.out.println("ha");
                receiveFile();
            }
        
        
    }
    public void receiveFile() {
        byte[] receiveData = new byte[PIECES_OF_FILE_SIZE];
        DatagramPacket receivePacket;
         
        try {
            // get file info
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);
            InetAddress inetAddress = receivePacket.getAddress();
            ByteArrayInputStream bais = new ByteArrayInputStream(
                    receivePacket.getData());
            ObjectInputStream ois = new ObjectInputStream(bais);
            FileInfo fileInfo = (FileInfo) ois.readObject();
            // show file info
            if (fileInfo != null) {
                System.out.println("File name: " + fileInfo.getFileName());
                System.out.println("File size: " + fileInfo.getFileSize());
                System.out.println("Pieces of file: " + fileInfo.getPiecesOfFile());
                System.out.println("Last bytes length: "+ fileInfo.getLastBytesLength());
            }
            // get file content
            System.out.println("Receiving file...");
            File fileReceive = new File(fileInfo.getDestinationDirectory() 
                    + fileInfo.getFileName());
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(fileReceive));
            // write pieces of file
            int persons = fileInfo.getPiecesOfFile() - 1;
            for (int i = 0; i < (fileInfo.getPiecesOfFile() - 1); i++) {
                receivePacket = new DatagramPacket(receiveData, receiveData.length, 
                        inetAddress, serverPort);
                clientSocket.receive(receivePacket);
                bos.write(receiveData, 0, PIECES_OF_FILE_SIZE);
                System.out.println(((float)i/persons)*100 + "%");
            }
            // write last bytes of file
            receivePacket = new DatagramPacket(receiveData, receiveData.length, 
                    inetAddress, serverPort);
            clientSocket.receive(receivePacket);
            bos.write(receiveData, 0, fileInfo.getLastBytesLength());
            bos.flush();
            System.out.println("Done!");
     
            // close stream
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // String sourcePath = "D:\\client\\test.zip";
        // String destinationDir = "D:\\server\\";
        
        try {
            Client udpClient = new Client();
            udpClient.connectServer();
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        // udpClient.sendFile(sourcePath, destinationDir);
    }
}