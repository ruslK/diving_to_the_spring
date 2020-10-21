import intefaces.Course;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Course java1 = container.getBean("java", Course.class);
        Course java2 = container.getBean("java", Course.class);

        System.out.println(java1);
        System.out.println(java2);
        System.out.println(java1 == java2);
        System.out.println(java1.equals(java2));


        Course sel1 = container.getBean("selenium", Course.class);
        Course sel2 = container.getBean("selenium", Course.class);

        System.out.println(sel1);
        System.out.println(sel2);
        System.out.println(sel1 == sel2);
        System.out.println(sel1.equals(sel2));

    }
}
