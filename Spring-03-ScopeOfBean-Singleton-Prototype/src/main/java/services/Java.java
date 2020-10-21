package services;

import intefaces.Course;

public class Java implements Course {


    public void initMethod() {
        System.out.println("Java Init Method");
    }

    @Override
    public void getTeachingHours() {
        System.out.println("getting Java course");
    }
}
