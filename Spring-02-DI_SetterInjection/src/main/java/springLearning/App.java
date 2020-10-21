package springLearning;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springLearning.interfaces.Course;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course java = container.getBean("java", Course.class);
        java.getTeachingHours();

//        Course selenium = container.getBean("selenium", Course.class);
//        selenium.getTeachingHours();
    }
}
