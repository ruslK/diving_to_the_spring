package springLearning.servises;


import lombok.Data;
import springLearning.interfaces.Course;
import springLearning.interfaces.ExtraSession;

@Data
public class Java implements Course {

    ExtraSession extraSession;

    @Override
    public void getTeachingHours() {
        System.out.println("Java hours: " + (20 + extraSession.getHours()));
    }
}
