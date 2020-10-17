package servises;

import interfaces.Mentor;

public class FullTimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("Full Time Mentor created ... ");
    }
}
