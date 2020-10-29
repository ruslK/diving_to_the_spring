package edu.store.calculation.services.carperts.Carperts;

import edu.store.calculation.enums.CityTX;
import edu.store.calculation.interfaces.Carpet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class CarpetTX implements Carpet {

    @Value("${city}")
    private String city;

    @Override
    public double getSaleTax() {
        return 6.25;
    }

    @Override
    public double getCarpetPriceSquareFoot() {
        try {
            return (Enum.valueOf(CityTX.class, city)).getPrice();
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException("We don't sell Carpet in the " + city);
        }
    }
}
