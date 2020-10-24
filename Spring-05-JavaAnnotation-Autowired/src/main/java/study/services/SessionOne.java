package study.services;

import org.springframework.stereotype.Component;
import study.interfaces.Sessions;

@Component
public class SessionOne implements Sessions {

    @Override
    public int getSessions() {
        return 5;
    }
}
