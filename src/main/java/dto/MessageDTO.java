package dto;

import com.github.javafaker.Faker;

import static utils.PropertyFileHandler.CONTENT;
import static utils.PropertyFileHandler.RECIPIENT_EMAIL;
import static utils.PropertyFileHandler.SUBJECT;

public class MessageDTO {

    private String recipientEmail;
    private String subject;
    private String content;

    public MessageDTO() {
        Faker faker = new Faker();
        recipientEmail = RECIPIENT_EMAIL;
        subject = SUBJECT + " " + faker.artist().name();
        content = CONTENT + " " + faker.beer().name();
    }

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MessageDTO{" +
                "recipientEmail='" + recipientEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
