import java.util.*;


import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.*;

// import java.net.*;
public class MailApp{
    public static void main(String[] args) throws Exception {
        System.out.println("haha");
	sendMail("nguoigiaumat100@gmail.com");
    }
    public static void sendMail(String recepient) throws Exception{

        System.out.println("Preparing to send mail...");

        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        String myAccount = "thanhui84426@gmail.com";
        String myPassword = "t.74488222";

        Session session = Session.getInstance(properties, new Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccount,myPassword);
            }
        });
        Message message = prepareMessage(session,myAccount, recepient);
        Transport.send(message);
        System.out.println("Message send successfully");
    }
    private static Message prepareMessage(Session session, String myAccount, String recepient){
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccount));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("My first email from java app.");
            message.setText("here are various ways to send email using JavaMail API. For th");
            return message;
        } catch (Exception e) {
            //TODO: handle exception
            // Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("err");
        }
        return null;
    }
}
//javac -classpath javax.mail.jar Mail.java
//javac -classpath javax.mail.jar MailJavaUntil.java Mail.java && java Mail
