package com.springLearning.servises;

import com.springLearning.interfaces.ExtraSession;

public class OfficeHours implements ExtraSession {

    @Override
    public int getHours() {
        return 5;
    }
}
