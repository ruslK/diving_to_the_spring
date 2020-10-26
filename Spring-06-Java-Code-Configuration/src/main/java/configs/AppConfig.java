package configs;

import interfaces.ExtraSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import services.OfficeHours;
import services.Selenium;

@Configuration
@ComponentScan("services")
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Bean
    public Selenium selenium() {
        return new Selenium(extraSession());
    }

    @Bean
    public ExtraSession extraSession() {
        return new OfficeHours();
    }
}
