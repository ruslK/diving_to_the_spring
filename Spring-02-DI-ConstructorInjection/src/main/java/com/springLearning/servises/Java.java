package com.springLearning.servises;

import com.springLearning.interfaces.Course;

public class Java implements Course {

    OfficeHours officeHours;

    @Override
    public void getTeachingHours() {
        System.out.println("Java hours: " + (20 + officeHours.getHours()));
    }
}
