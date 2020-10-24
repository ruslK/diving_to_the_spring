package com.study.services;

import com.study.interfaces.Course;


public class Selenium implements Course {

    @Override
    public void getTeachingHours() {
        System.out.println("Java getTeachingHours: 23");
    }
}
