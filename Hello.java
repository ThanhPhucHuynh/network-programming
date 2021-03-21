import java.util.Scanner;
import java.lang.Math;
import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.FileInputStream;
import java.io.*;
 
public class Hello{

    public static String textInputWrong(){ 
        return "Fail input";
    }

    public static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        System.out.println("Test Lab 1: ");

        int youChoose = 0;

        while(true){
           
            try {
                
                youChoose = sc.nextInt();
               
                if(youChoose == 1 ) testOne();
                if(youChoose == 2 ) testTwo(); 
                if(youChoose == 13) break;

            } catch (Exception e) {
                sc.nextLine();
                //TODO: handle Exception
                System.out.println(textInputWrong());

            }
        }

    }

    public static void testOne(){
        int n;
        float x;
        boolean checkOut = !true; 
        while(!checkOut)
        try {

            System.out.println("Input int n: ");
            n = sc.nextInt();   

            System.out.println("Input float x: ");           
            x = sc.nextFloat();

            System.out.println("Math Pow (x ,n ): "+ Math.pow(x,n));
            sc.nextLine();

            checkOut = !checkOut;
        } catch (Exception e) {
            sc.nextLine();
            //TODO: handle exception
            System.out.println(textInputWrong());
        }
        

    }    
    public static void testTwo() {
        
        try {
            FileInputStream fin = new FileInputStream("filename.txt");
            int len = fin.available();
          
            System.out.println("InputStream: ");
            for(int i = 0; i<len;i++){
                System.out.print((char)fin.read());
            }

            FileInputStream fin2 = new FileInputStream("filename.txt");
            int len2 = fin2.available();
          
            byte b[] = new byte[100];
            int n = fin2.read(b);
            String str = new String(b,0,n);

            System.out.println("\nInputStream byte: "+ str);
            fin.close();
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("fail io");
        }
        
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("\nused Scanner: " + data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // public static 
  
}