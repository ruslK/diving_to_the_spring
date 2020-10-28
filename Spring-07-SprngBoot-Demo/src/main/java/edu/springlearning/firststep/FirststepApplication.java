package edu.springlearning.firststep;

import edu.springlearning.firststep.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirststepApplication {

    public static void main(String[] args) {
        ApplicationContext cont = SpringApplication.run(FirststepApplication.class, args);
        Course course = cont.getBean("java", Course.class);

        System.out.println(course.getTeachingHours());

    }

}
