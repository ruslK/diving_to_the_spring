package springLearning.servises;


import springLearning.interfaces.ExtraSession;

public class OfficeHours implements ExtraSession {

    @Override
    public int getHours() {
        return 5;
    }
}
