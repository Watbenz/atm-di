package anno_config;

import atm.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("anno_config.xml");
        ATMSimulator atmSimulator = context.getBean(ATMSimulator.class);
        atmSimulator.run();

    }
}
