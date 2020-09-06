package smtpservice;

import com.sun.mail.smtp.SMTPTransport;
import userdata.User;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

import static logger.AllureLogger.logToAllureError;
import static logger.AllureLogger.logToAllureInfo;
import static utils.PropertyFileHandler.*;

public class MailSender {

    //   For all new accounts log-in to Google-account and run this url to enable lesssecureapps
    //    https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web&hl=uk

    public void sendDefaultMessage(User user) {

        logToAllureInfo("Sending a default letter from: " + user.getEmail() + " to recipient");
        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.timeout", 5000);
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(user.getEmail()));
            logToAllureInfo("Setting data of the default letter from smptp-sender ");
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(DEFAULT_RECIPIENT_EMAIL, false));
            msg.setSubject(DEFAULT_SUBJECT);
            msg.setText(DEFAULT_CONTENT);
            msg.setSentDate(new Date());
            SMTPTransport transport = (SMTPTransport) session.getTransport("smtps");
            transport.connect("smtp.gmail.com", user.getEmail(), user.getPassword());
            transport.sendMessage(msg, msg.getAllRecipients());
            logToAllureInfo("Response from smtp-mail-transport: " + transport.getLastServerResponse());
            transport.close();
        } catch (MessagingException e) {
            logToAllureError(e.getMessage());
        }
    }
}
