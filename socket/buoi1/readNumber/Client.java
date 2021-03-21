import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println(args[0]);
        try {
            // System.out.println("HEllo World");
            Socket s = new Socket(args[0],7);

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            DataInputStream dis=new DataInputStream(s.getInputStream());  
            while(true){
                System.out.print("\ninput: ");
                int youChoose = sc.nextInt();
                os.write(youChoose);
                String ch = (String)dis.readUTF();  
                System.out.print(ch);
            }

            // for(int i = '0'; i<= '9';i++){
            //     os.write(i);
            //     int ch = is.read();
            //     System.out.print((char)ch);
            // }

        } catch (IOException ie) {
            //TODO: handle exception
            System.out.println("Something wrong!"+ie);
        }
    }
}