package edu.store.calculation.services.carperts.Floors;

import edu.store.calculation.interfaces.Floor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Kitchen implements Floor {

    @Value("${radius}")
    private double radius;

    @Override
    public double calculateArea() {
        return 3.14 * (radius * radius);
    }
}
