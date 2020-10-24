package services;

import intefaces.Course;

public class Java implements Course {


    public void initMethod() {
        System.out.println("Java Init Method");
    }

    public void destroyMethod() {
        System.out.println("Java Destroy Method");
    }

    @Override
    public void getTeachingHours() {
        System.out.println("getting Java course");
    }
}
