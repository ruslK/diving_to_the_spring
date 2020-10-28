package edu.springlearning.firststep.services;

import edu.springlearning.firststep.interfaces.ExtraSession;
import org.springframework.stereotype.Component;

@Component
public class PartTime implements ExtraSession {
    @Override
    public int getExtraHours() {
        return 3;
    }
}
