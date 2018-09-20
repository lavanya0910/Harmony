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

public class SendOtp {
	 public static void sendEmail(String host, String port,
            final String userName, final String password, String toAddress,
            String subject,String otp) throws AddressException, MessagingException {
		 
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
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setContent("Dear  Sir/Mam, <br>"+"<h1>Your One Time password is</h1> <h1>"+ otp+"</h1>"
         		, "text/html");
        Transport.send(msg);
        System.out.println("Mail successfully sent");
	}
}

