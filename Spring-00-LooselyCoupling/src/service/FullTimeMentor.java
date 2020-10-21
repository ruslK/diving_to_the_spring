package service;

import implementation.Mentor;

public class FullTimeMentor implements Mentor {

    @Override
    public void createAccount() {
        System.out.println("FullTimeMentor created");
    }
}
