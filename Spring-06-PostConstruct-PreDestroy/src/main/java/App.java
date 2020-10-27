import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.configs.AppConfig;
import study.interfaces.Course;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);

        Course course = container.getBean("java", Course.class);
        course.getTeachingHours();

        ((AnnotationConfigApplicationContext) container).close();
    }
}
