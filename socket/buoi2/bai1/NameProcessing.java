import java.util.*;
import java.net.*;
import java.io.*;
class NameProcessing extends Thread {

    private Socket socket;
    public NameProcessing(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            while(true){
                byte[] fullname = new byte[1000];
                // int n =  is.read(fullname);
                String fullnameStr = new String(fullname,0,is.read(fullname));
                
                System.out.println(fullnameStr);
                
                os.write(nameTrim(fullnameStr).getBytes());
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Exception"+ e.toString());
        }
    }
    public static String nameTrim(String fullname) {
        return fullname.split(" ")[fullname.split(" ").length -1];        
    }
}