package com.heights.auditapp.notification.mail;

import com.heights.auditapp.encrypt.PBEncrytor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Configuration
public class SendMail {

	@Value("${spring.mail.username}")
    private String username;
	@Value("${spring.mail.password}")
    private String password;
	@Value("${spring.mail.host}")
    private String host;
	@Value("${spring.mail.port}")
    private String port;

    private final PBEncrytor encryptors;

    @Autowired
    public SendMail(PBEncrytor encryptors) {
        this.encryptors = encryptors;
    }

    public void sendEMail(MailRequest mailRequest) {

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");   //make it true
        properties.put("mail.smtp.starttls.enable", "true"); //make it true
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(encryptors.PBDecrypt(username), encryptors.PBDecrypt(password));
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(username));

            // Set To: header field of the header.
            InternetAddress[] addresses = new InternetAddress[mailRequest.getRecipientEmailAddress().size()];
            for (int i = 0; i < mailRequest.getRecipientEmailAddress().size(); i++) {
                addresses[i] = new InternetAddress(mailRequest.getRecipientEmailAddress().get(i));
            }
            message.addRecipients(Message.RecipientType.TO, addresses);

            // Set Subject: header field
            message.setSubject(mailRequest.getMailSubject());

            // Now set the actual message
            message.setContent(mailRequest.getMessageBody(), "text/html");

            System.out.println("sending mail...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
