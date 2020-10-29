package edu.store.calculation.enums;

public enum CityTX {
    Dallas("Dallas", 17.5),
    Austin("Austin", 19.7),
    SanAntonio("San Antonio", 20.5);

    private String city;
    private double price;


    CityTX(String city, double price) {
        this.city = city;
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
