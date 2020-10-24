package study.services;

import org.springframework.stereotype.Component;
import study.interfaces.ExtraSession;

@Component
public class OfficeHours implements ExtraSession {
    @Override
    public int getExtraSession() {
        return 10;
    }
}
