package springLearning.services;


import springLearning.interfaces.Course;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Selenium hours: 25");
    }
}
