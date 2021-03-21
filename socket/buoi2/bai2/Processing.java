import java.util.*;
import java.net.*;
import java.io.*;
import java.nio.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

class Processing extends Thread {

    private Socket socket;
    public Processing(Socket socket){
        this.socket = socket;
    }
    public void run(){
        try {
            OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            while(true){
                byte[] script = new byte[1000];
                String scriptStr = new String(script,0,is.read(script));
                // System.out.println(getDirectoryPath(scriptStr));
                File file = new File(getDirectoryPath(scriptStr));

                String result = getListDirectoryRecursive(file,0);      
                os.write(result.getBytes());
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Exception socket: "+ e);
        }
    }
    public static String getDirectoryPath(String fullInput) {
        System.out.println(fullInput);
        return fullInput.split(" ")[fullInput.split(" ").length - 1];
    }
    public static void listDirectoryRecursive(File dirPath,int countRoot,String ...FolderParents) throws IOException{
        String numChar = "";
        try {
            File[] filesList = dirPath.listFiles();
            for (File file : filesList){
                if (file.isFile()) {
                    for (int i = 0; i <countRoot; i++) numChar += " -> ";
                    System.out.println("File path: "+numChar+ file.getName());
                }else{
                    for (int i = 0; i <countRoot; i++) numChar += " -> ";
                    System.out.println("File path: "+numChar + file.getName());
                    listDirectoryRecursive(file,countRoot+1,file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Ex IOList: "+e.getMessage());
            //TODO: handle exception
        }
    }
    public static String getListDirectoryRecursive(File dirPath,int countRoot,String ...FolderParents) throws IOException{
        String numChar = "";
        String listOne = "";
        File[] filesList = dirPath.listFiles();
        for (File file : filesList){
            if (file.isDirectory()) {
                for (int i = 0; i <countRoot; i++) {numChar += " -> ";}
                listOne+="File path: "+numChar+ file.getName()+ "\n"+ getListDirectoryRecursive(file,countRoot+1,file.getName());
            }else{
               
                for (int i = 0; i <countRoot; i++) {numChar += " -> ";}
                listOne+= "File path: "+numChar+ file.getName()+ "\n";
            }
        }
        return listOne;
    }
    public static String nameTrim(String fullname) {
        return fullname.split(" ")[fullname.split(" ").length -1];        
    }
}