package edu.store.calculation.enums;

public enum CityVA {
    Arlington("Arlington", 16.9),
    Fairfax("Fairfax", 18.77),
    McLean("McLean", 23.55);

    private String city;
    private double price;


    CityVA(String city, double price) {
        this.city = city;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
