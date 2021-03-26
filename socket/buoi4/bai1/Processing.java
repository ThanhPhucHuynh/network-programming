import java.util.*;
import java.net.*;
import java.io.*;

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
                System.out.println(scriptStr);
                
                System.out.println(getURLSource(scriptStr).length());
                // String result = "Dsa";     
                os.write(getURLSource(scriptStr).getBytes());
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("Exception socket: "+ e);
        }
    }
    // public static String getURLSource(String url)
    // {
    //     URL urlObject = new URL(url);
    //     URLConnection urlConnection = urlObject.openConnection();
    //     urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

    //     return toString(urlConnection.getInputStream());
    // }
    public static String getURLSource(String urlInput) {
        try {
            URL url = new URL(urlInput);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            String result = "";
            while ((inputLine = in.readLine()) != null)
                result+=inputLine+"\n";
            in.close();
            return result;    
        } catch (Exception e) {
            System.err.println(e);
            return "err";
            //TODO: handle exception
        }
        
    }
   
}