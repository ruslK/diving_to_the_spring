package edu.store.calculation;

import edu.store.calculation.services.carperts.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring07CalculationApplication {

    public static void main(String[] args) throws Exception {

        ApplicationContext container = SpringApplication.run(Spring07CalculationApplication.class, args);
        Calculator cal = container.getBean("calculator", Calculator.class);

        cal.getQuoteForCarpet();
    }


}
