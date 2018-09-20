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

import model.accummodate;

public class EmailUtility2 {
	public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject, String ccadd,accummodate message) throws AddressException,
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
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setContent("Dear,Sir/Madam,<b><br>Accomodation details are as follows:<br><br>"
         		+"<table border=2px solid #dddddd style=font-family:monotype cursor>"
        		+ "<tr>"
         		+ "<th>registration Number</th>"
         		+ "<th>"+message.getRegister_id()+"</th></tr>"
         		+ "<tr>"
         		+ "<th>Amount</th>"
         		+ "<th>"+message.getAmount()+"</th></tr>"
         		+ "<tr>"
         		+ "<th>Transcation reference number</th>"
         		+ "<th>"+message.getTranssactionalrefno()+"</th></tr>"
         		+ "<tr>"
         		+ "<th>Date of transcation</th>"
         		+ "<th>"+message.getDateoftrans()+"</th></tr>"
         		+ "<tr>"
         		+ "<th>Email</th>"
         		+ "<th>"+message.getEmail()+"</th></tr>"
         		
         		+ "</table>"
         		, "text/html");
        Transport.send(msg);
        System.out.println("Mail successfully sent");
//      creates message part
     		MimeBodyPart messageBodyPart = new MimeBodyPart();
    }

}
