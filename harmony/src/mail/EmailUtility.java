package mail;

import java.util.Date;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;

import model.Registration;
 
public class EmailUtility {
    public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String ccadd,Registration message) throws AddressException,
            MessagingException {
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO,toAddresses);
        msg.addRecipient(Message.RecipientType.CC, new InternetAddress(ccadd));
        msg.setSubject("Harmony 2019 -Registration Acknowledgement");
        msg.setSentDate(new Date());
        msg.setContent("Respected "+ message.getName()+" ,"+"<br><b><br>Registration details as follows<br><br></b>"
         		+ "<table border=2px solid #dddddd style=border-collapse: collapse; font-family:monotype cursor >"
        		+ "<tr>"
        		+ "<th>Registration Number</th>"
        		+ "<th>"+ message.getRegister_id()+"</th></tr>"
        		+ "<tr>"
         		+ "<th>Email</th>"
        		+ "<th>"+message.getEmail()+"</th></tr>"
        		+ "<tr>"
         		+ "<th>Country</th>"
        		+ "<th>"+message.getCounter()+"</th></tr>"
        		+ "<tr>"
         		+ "<th>Institution</th>"
        		+ "<th>"+message.getInstitution()+"</th></tr>"
        		+ "<tr>"
         		+ "<th>Date of Registering</th>"
        		+ "<th>"+message.getDate()+"</th></tr>"
        		+ "<tr>"
         		+ "<th>Time of Registering</th>"
        		+ "<th>"+message.getTime()+"</th</tr>"
        		+ "<tr>"
         		+ "<th>Transaction Reference:</th>"
        		+ "<th>"+message.getTranssactionalrefno()+"</th></tr>"
         		
         	+"</table>"
         		, "text/html");
        Transport.send(msg);
        System.out.println("Mail successfully sent");
//      creates message part
     		MimeBodyPart messageBodyPart = new MimeBodyPart();
    }
}