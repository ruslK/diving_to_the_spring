package services;


import intefaces.Course;

public class Selenium implements Course {

    public void initMethod() {
        System.out.println("Selenium Init Method");
    }

    @Override
    public void getTeachingHours() {
        System.out.println("getting Selenium course");
    }
}
