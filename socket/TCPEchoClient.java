import java.io.*;
import java.net.*;

public class TCPEchoClient{
    public static void main(String args[]){
        System.out.println(args[0]);
        try {
            // System.out.println("HEllo World");
            Socket s = new Socket(args[0],7);

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            for(int i = '0'; i<= '9';i++){
                os.write(i);
                int ch = is.read();
                System.out.print((char)ch);
            }

        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Something wrong!"+ie);
        }
    }
}