package omegadeveloper.mvc.controllers;

import omegadeveloper.messaging.JMSReceiver;
import omegadeveloper.messaging.JMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liviu on 2/23/2016.
 */

@Controller
@Component
public class MVCSecureAppController {

    @Autowired
    ConfigurableApplicationContext context;

    @Autowired
    JMSSender jmsSender;

    @Autowired
    JMSReceiver jmsReceiver;

    @RequestMapping("/sendText")
    public String sendJMSTest(Model model){
        jmsSender.send("CoolText");
        //returns the view name
        return "textSent";
    }

    @RequestMapping("/getText")
    public String jmsText(Model model){

        model.addAttribute("message", context.getBean("messages"));
        //returns the view name

        return "textReceived";
    }
}
