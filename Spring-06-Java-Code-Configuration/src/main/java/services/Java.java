package services;

import interfaces.Course;
import interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Java implements Course {

    @Autowired
    @Qualifier("vocationHours")
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

    @Override
    public void getTeachingHours() {
        System.out.println("30 hours + " + extraSession.getHours());
    }
}
