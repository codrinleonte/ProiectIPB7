package com.fiiLicence.fiiLicence.services.bd;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;


public class MailSender {

    public MailSender(String email, String hascode) {

        final String username = "dan.giani123@gmail.com";
        final String password = "42428531";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            String mailBody = "http://localhost:4200/activation?activate=" + hascode;
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dan.giani@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("Confirmare inscriere", "text/html; charset=utf-8");
            message.setContent("<html>" +
                    "<body>\n" + "<p>&nbsp;</p>" +
                    "Stimate student/a\n" +
                    "\n" + "<p>Pentru a putea folosi serviciul te rugam sa confirmi la urmatorul link :&nbsp;" +
                    "<a href=\"" + mailBody + "\">" +
                    "</a>" + "Mail-de-activare!</p>" + "<p>&nbsp;</p>" + "<div>&nbsp;</div>\n" +
                    "<p></p> <p>Echipa B7 :)</p>" +
                    "</body>" +
                    "</html>", "text/html; charset=utf-8");
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}