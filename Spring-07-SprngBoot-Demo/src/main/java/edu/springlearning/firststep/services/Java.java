package edu.springlearning.firststep.services;

import edu.springlearning.firststep.interfaces.Course;
import edu.springlearning.firststep.interfaces.ExtraSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    @Autowired
    @Qualifier("partTime")
    private ExtraSession partTime;

    private ExtraSession overTime;


    @Value("${extraHours}")
    private int hours;

    public Java(@Qualifier("overTime") ExtraSession extraSession) {
        this.overTime = extraSession;
    }

    @Override
    public int getTeachingHours() {
        return 5
                + overTime.getExtraHours()
                + partTime.getExtraHours()
                + hours;
    }
}
