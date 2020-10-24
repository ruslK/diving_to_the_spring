package study.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import study.interfaces.Course;

import java.util.Arrays;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Java implements Course {

    @Value("${instructor}")
    private String instructor;

    @Value("Current")
    private String batch;

    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "instructor='" + instructor + '\'' +
                ", batch='" + batch + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }

    @Override
    public void getTeachingHours() {
        System.out.println(instructor + " made 30 hours");
    }
}
