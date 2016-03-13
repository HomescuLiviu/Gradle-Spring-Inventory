package omegadeveloper.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.File;

/**
 * Created by liviu on 2/27/2016.
 */
@Component
public class JMSSender {

    /**
     * Get a copy of the application context
     */
    @Autowired
    ConfigurableApplicationContext context;


    public void send(String message){

        FileSystemUtils.deleteRecursively(new File("activemq-data"));

        // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("ping!");
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send("mailbox-destination-2", messageCreator);
    }


}
