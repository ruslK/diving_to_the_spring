package study.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import study.interfaces.Course;
import study.interfaces.ExtraSession;

@Component
public class Java implements Course {

    private ExtraSession extraSession;
    private final OfficeHours officeHours;


    /*
    Construction Injection
     */
    @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    /*
    Setter Injection
     */
    @Autowired
    public void setExtraSession(ExtraSession extraSession) {
        this.extraSession = extraSession;
    }

    /*
    Field Injection
     */
    @Autowired
    private ExtraSession fieldExtraSession;

    @Override
    public void getTeachingHours() {
        System.out.println("Java getTeachingHours: "
                + (30 + officeHours.getExtraSession()
                + extraSession.getExtraSession()
                + fieldExtraSession.getExtraSession()));
    }
}
