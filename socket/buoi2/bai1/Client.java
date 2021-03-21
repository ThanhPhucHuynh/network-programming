import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
    
    public static void main(String[] args){
        System.out.println("Hello I'm a client");
       
        try {
            Scanner scanner = new Scanner(System.in);
            Socket s = new Socket(args[0],7);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true){
                System.out.print("Input fullname: ");
                String fullname = scanner.nextLine();
                os.write(fullname.getBytes());

                byte[] result = new byte[1000];
                int len = is.read(result);

                String resultStr = new String(result,0,len);
                System.out.println("Result: "+resultStr);
            }
            // s.close();

        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("Error"+ e.toString());
        }
        // Create

    }
}
