package study;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import study.interfaces.Course;

public class App {
    public static void main(String[] args) {
        ApplicationContext conteiner = new ClassPathXmlApplicationContext("config.xml");

        Course course = conteiner.getBean("java", Course.class);
        course.getTeachingHours();

        Course course2 = conteiner.getBean("selenium", Course.class);
        course2.getTeachingHours();

    }
}
