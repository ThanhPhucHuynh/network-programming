import java.util.*;
import java.io.*;
import java.net.*;

public class Client{
    public static void main(String args[]){
        System.out.println("I'm a client ...");
        Scanner scanner = new Scanner(System.in);
        try {
            Socket s = new Socket(args[0],7);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            while(true){
                System.out.print("Input url:  ");
                String script = scanner.nextLine();
                os.write(script.getBytes());

                byte[] result = new byte[20000];
                int len = is.read(result);

                String resultStr = new String(result,0,len);
                System.out.println("Result (content of url): "+resultStr);

            }

        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("error: " + e.getMessage());
        }
    }
}