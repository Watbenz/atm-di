package java_config;

import atm.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMSimConfig {
    @Bean
    public DataSource getDataSource() { return new DataSource("customers.txt"); }

    @Bean
    public Bank getBank() { return new Bank(getDataSource()); }

    @Bean
    public ATM getATM() { return new ATM(getBank()); }

    @Bean
    public ATMSimulator getSimulator() { return new ATMSimulator(getATM()); }
}
