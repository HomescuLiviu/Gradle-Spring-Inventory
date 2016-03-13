package omegadeveloper.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * Created by liviu on 2/27/2016.
 */
@Component
public class JMSReceiver {

    /**
     * Get a copy of the application context
     */
    @Autowired
    ConfigurableApplicationContext context;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "mailbox-destination")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        FileSystemUtils.deleteRecursively(new File("activemq-data"));
    }
}
