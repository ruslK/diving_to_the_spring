package services;

import interfaces.Course;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("30 hours");
    }
}
