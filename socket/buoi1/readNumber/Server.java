import java.net.*;
import java.io.*;

public class Server{

    public final static int defaultPort = 7;
    public static void main(String args[]) {
        try {
            ServerSocket ss = new ServerSocket(defaultPort);
            
            while(true){
                try {
                    Socket s = ss.accept();
                    OutputStream os = s.getOutputStream();
                    InputStream is = s.getInputStream();
                    DataOutputStream dout=new DataOutputStream(s.getOutputStream());
                    int ch = 0;
                    while(true){
                        ch = is.read();
                        if(ch==-1) break;
                        // System.out.print(convertNumberToString(ch));
                        dout.writeUTF(convertNumberToString(ch));
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
    public static String convertNumberToString(int a){
        String result = "";
        switch (a) {
            case 1:
                result = "one";
                break;
            case 2:
                result =  "two";
                break;
            case 3:
                result =  "three";
                break;
            case 4:
                result =  "four";
                break;
            case 5:
                result =  "five";
                break;
            case 6:
                result =  "six";
                break;
            case 7:
                result =  "seven";
                break;
            case 8:
                result =  "eight";
                break;
            case 9:
                result =  "nice";
                break;
            case 10:
                result =  "ten";
                break;                
            default:
                result =  "against";
                break;
        }
        return result;
    }
}