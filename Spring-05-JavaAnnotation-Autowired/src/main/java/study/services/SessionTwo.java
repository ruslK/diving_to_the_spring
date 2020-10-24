package study.services;

import org.springframework.stereotype.Component;
import study.interfaces.Sessions;

@Component
public class SessionTwo implements Sessions {
    @Override
    public int getSessions() {
        return 6;
    }
}
