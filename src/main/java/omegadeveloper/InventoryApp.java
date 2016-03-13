package omegadeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;

/**
 * Created by liviu on 3/10/2016.
 */
@ComponentScan
@SpringBootApplication
@EnableJms
public class InventoryApp {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(InventoryApp.class, args);
    }
}
