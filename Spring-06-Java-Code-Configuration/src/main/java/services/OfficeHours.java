package services;

import interfaces.ExtraSession;

public class OfficeHours implements ExtraSession {
    @Override
    public int getHours() {
        return 4;
    }
}
