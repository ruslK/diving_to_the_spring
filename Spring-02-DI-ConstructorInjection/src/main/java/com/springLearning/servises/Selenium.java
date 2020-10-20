package com.springLearning.servises;

import com.springLearning.interfaces.Course;

public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Selenium hours: 25");
    }
}
