import com.study.interfaces.API;
import com.study.interfaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext conteiner = new ClassPathXmlApplicationContext("config.xml");

        Course course = conteiner.getBean("java", Course.class);
        course.getTeachingHours();

        API api = conteiner.getBean("API", API.class);
        api.getSomeData();

    }
}
