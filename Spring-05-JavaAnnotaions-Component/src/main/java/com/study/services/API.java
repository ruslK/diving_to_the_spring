package com.study.services;

import org.springframework.stereotype.Component;

@Component
public class API implements com.study.interfaces.API {

    @Override
    public void getSomeData() {
        System.out.println("Some API");
    }
}
