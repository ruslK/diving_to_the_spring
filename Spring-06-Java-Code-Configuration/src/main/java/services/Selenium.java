package services;


import interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Java getTeachingHours: 23");
    }
}
