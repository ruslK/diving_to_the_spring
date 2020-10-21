package com.springLearning.servises;

import com.springLearning.interfaces.Course;
import com.springLearning.interfaces.ExtraSession;

public class Java implements Course {

    ExtraSession officeHours;

    public Java(ExtraSession officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Java hours: " + (20 + officeHours.getHours()));
    }
}
