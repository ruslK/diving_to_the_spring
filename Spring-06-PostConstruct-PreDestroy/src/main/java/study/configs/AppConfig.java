package study.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import study.services.Selenium;

@Configuration
@ComponentScan("study.services")
public class AppConfig {

    @Bean
    public Selenium selenium() {
        return new Selenium();
    }
}
