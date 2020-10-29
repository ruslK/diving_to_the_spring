package edu.store.calculation.services.carperts.Floors;

import edu.store.calculation.interfaces.Floor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BedRoom implements Floor {

    @Value("${length}")
    private double length;

    @Override
    public double calculateArea() {
        return length * length;
    }
}
