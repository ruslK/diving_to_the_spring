import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

//        Mentor fullTime = (Mentor) container.getBean("fullTimeMentor");
//        Mentor partTime = (Mentor) container.getBean("partTimeMentor");
//        fullTime.createAccount();
//        partTime.createAccount();

        Mentor mentor = container.getBean("fullTimeMentor", Mentor.class);
        mentor.createAccount();
    }
}
