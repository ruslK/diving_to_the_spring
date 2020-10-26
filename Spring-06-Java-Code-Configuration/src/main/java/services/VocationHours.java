package services;

import interfaces.ExtraSession;
import org.springframework.stereotype.Component;

@Component
public class VocationHours implements ExtraSession {
    @Override
    public int getHours() {
        return 15;
    }
}
