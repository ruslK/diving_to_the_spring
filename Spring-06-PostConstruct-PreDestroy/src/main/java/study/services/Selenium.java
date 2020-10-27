package study.services;

import org.springframework.stereotype.Component;
import study.interfaces.Course;

@Component
public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Java getTeachingHours: 23");
    }
}
