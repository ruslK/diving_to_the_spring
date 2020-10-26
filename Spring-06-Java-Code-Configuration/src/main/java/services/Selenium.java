package services;


import interfaces.Course;
import interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;


public class Selenium implements Course {

    private ExtraSession extraSession;

    @Value("Test")
    private String batch;

    @Value("${instructor}")
    private String instructor;

    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    public Selenium(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    public void getTeachingHours() {

        System.out.println("Selenium getTeachingHours: " + (23 + extraSession.getHours()));
    }
}
