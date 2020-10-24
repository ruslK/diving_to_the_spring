package study.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import study.interfaces.Course;
import study.interfaces.Sessions;

@Component
public class Selenium implements Course {

    @Autowired
    @Qualifier("sessionOne")
    private Sessions sessions;

    private Sessions sessionsTwo;

    @Autowired
    public Selenium(@Qualifier("sessionTwo") Sessions sessionsTwo) {
        this.sessionsTwo = sessionsTwo;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Selenium getTeachingHours: "
                + (25 + sessions.getSessions() + sessionsTwo.getSessions()));
    }
}
