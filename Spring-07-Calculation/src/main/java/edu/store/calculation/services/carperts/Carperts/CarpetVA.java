package edu.store.calculation.services.carperts.Carperts;

import edu.store.calculation.enums.CityVA;
import edu.store.calculation.interfaces.Carpet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class CarpetVA implements Carpet {

    @Value("${city}")
    private String city;

    @Override
    public double getSaleTax() {
        return 5.3;
    }

    @Override
    public double getCarpetPriceSquareFoot() {
        try {
            return (Enum.valueOf(CityVA.class, city)).getPrice();
        } catch (NullPointerException e) {
            throw new NoSuchElementException("We don't sell Carpet in the " + city);
        }
    }
}
