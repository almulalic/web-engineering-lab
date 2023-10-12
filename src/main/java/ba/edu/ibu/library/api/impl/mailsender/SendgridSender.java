package ba.edu.ibu.library.api.impl.mailsender;

import ba.edu.ibu.library.core.api.MailSender;
import ba.edu.ibu.library.core.model.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConditionalOnProperty(name = "configuration.mailsender.default", havingValue = "sendgrid")
public class SendgridSender implements MailSender {
    @Override
    public String send(List<User> users, String message) {
        for(User user: users) {
            System.out.println("Message sent to: " + user.getEmail());
        }

        return "Message " + message + " | Sent via Sendgrid.";
    }
}
