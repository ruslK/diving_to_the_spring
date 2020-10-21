package springLearning.services;

import springLearning.interfaces.ExtraSession;

public class OfficeHours implements ExtraSession {

    @Override
    public int getHours() {
        return 5;
    }
}
