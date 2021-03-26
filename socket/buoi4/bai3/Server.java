
import java.util.*;
import java.io.*;
import java.net.*;


public class Server{
    private static final int PIECES_OF_FILE_SIZE = 1024 * 32;
    private DatagramSocket serverSocket;
    private int serverPort = 7;
    Scanner scanner = new Scanner(System.in);
    private void openServer() {
        try {
            serverSocket = new DatagramSocket();
            System.out.println("Server is opened on port " + serverPort);
            listening();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    private void listening() {
        while (true) {
            System.out.println("input: ");
            String sourcePath = scanner.nextLine();
            sendFile(sourcePath, "server/");
        }
    }
    private void sendFile(String sourcePath, String destinationDir) {
        InetAddress inetAddress;
        DatagramPacket sendPacket;
     
        try {
            File fileSend = new File(sourcePath);
            InputStream inputStream = new FileInputStream(fileSend);
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            inetAddress = InetAddress.getByName("225.1.1.1");

            byte[] bytePart = new byte[PIECES_OF_FILE_SIZE];
             
            // get file size
            long fileLength = fileSend.length();
            int piecesOfFile = (int) (fileLength / PIECES_OF_FILE_SIZE);
            int lastByteLength = (int) (fileLength % PIECES_OF_FILE_SIZE);
     
            // check last bytes of file
            if (lastByteLength > 0) {
                piecesOfFile++;
            }
     
            // split file into pieces and assign to fileBytess
            byte[][] fileBytess = new byte[piecesOfFile][PIECES_OF_FILE_SIZE];
            int count = 0;
            while (bis.read(bytePart, 0, PIECES_OF_FILE_SIZE) > 0) {
                fileBytess[count++] = bytePart;
                bytePart = new byte[PIECES_OF_FILE_SIZE];
            }
     
            // read file info
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(fileSend.getName());
            fileInfo.setFileSize(fileSend.length());
            fileInfo.setPiecesOfFile(piecesOfFile);
            fileInfo.setLastBytesLength(lastByteLength);
            fileInfo.setDestinationDirectory(destinationDir);
     
            // send file info
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(fileInfo);
            sendPacket = new DatagramPacket(baos.toByteArray(), 
                    baos.toByteArray().length, inetAddress, serverPort);
            serverSocket.send(sendPacket);
     
            // send file content
            System.out.println("Sending file...");
            // send pieces of file
            for (int i = 0; i < (count - 1); i++) {
                sendPacket = new DatagramPacket(fileBytess[i], PIECES_OF_FILE_SIZE,
                        inetAddress, serverPort);
                serverSocket.send(sendPacket);
                waitServer(40);
            }
            // send last bytes of file
            sendPacket = new DatagramPacket(fileBytess[count - 1], PIECES_OF_FILE_SIZE,
                    inetAddress, serverPort);
            serverSocket.send(sendPacket);
            waitServer(40);
     
            // close stream
            bis.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Sent.");
    }
    public void waitServer(long millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        Server udpServer = new Server();
        udpServer.openServer();
    }
}