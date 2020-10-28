package edu.springlearning.firststep.services;

import edu.springlearning.firststep.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public int getTeachingHours() {
        return 7;
    }
}
