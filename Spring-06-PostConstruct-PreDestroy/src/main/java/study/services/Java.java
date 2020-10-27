package study.services;

import org.springframework.stereotype.Component;
import study.interfaces.Course;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Java implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println(" made 30 hours");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("postConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("postConstruct");
    }
}
