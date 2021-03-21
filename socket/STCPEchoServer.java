import java.net.*;
import java.io.*;

public class STCPEchoServer{

    public final static int defaultPort = 7;
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(defaultPort);
            while(true){
                try {
                    Socket s = ss.accept();
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    int ch = 0;
                    while(true){
                        ch = is.read();
                        if(ch==-1) break;
                        os.write(ch);
                    }
                    s.close();

                } catch (IOException e) {
                    //TODO: handle exception
                    System.err.println("fail"+e);
                }
            }
        } catch (IOException e) {
            //TODO: handle exception
            System.err.println("fail"+e);
        }        
    }
}