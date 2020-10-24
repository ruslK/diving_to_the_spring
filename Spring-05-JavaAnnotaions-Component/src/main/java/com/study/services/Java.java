package com.study.services;

import com.study.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("Java getTeachingHours: 30");
    }
}
