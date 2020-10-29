package edu.store.calculation.services.carperts;

import edu.store.calculation.interfaces.Carpet;
import edu.store.calculation.interfaces.Floor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Value("${state}")
    private String state;

    @Value("${Room}")
    private String room;

    private Carpet carpetVA;
    private Carpet carpetTX;
    private Carpet carpet;

    private Floor bedRoom;
    private Floor kitchen;
    private Floor livingRoom;
    private Floor floor;

    public Calculator(Carpet carpetVA, Carpet carpetTX, Floor bedRoom, Floor kitchen, Floor livingRoom) {
        this.carpetVA = carpetVA;
        this.carpetTX = carpetTX;
        this.bedRoom = bedRoom;
        this.kitchen = kitchen;
        this.livingRoom = livingRoom;
    }

    public void getQuoteForCarpet() throws Exception {
        switch (state) {
            case "VA":
                carpet = carpetVA;
                break;
            case "TX":
                carpet = carpetTX;
                break;
        }

        switch (room) {
            case "Bedroom":
                floor = bedRoom;
                break;
            case "Kitchen":
                floor = kitchen;
                break;
            case "LivingRoom":
                floor = livingRoom;
                break;
        }

        double cost = carpet.getCarpetPriceSquareFoot() * floor.calculateArea();
        double taxes = cost * (carpet.getSaleTax() / 100);

        System.out.println("Quote for Carpet Price");
        System.out.println("1 sqf of carpet cost: $" + carpet.getCarpetPriceSquareFoot());
        System.out.println("Total Area of the Room of " + room + ": " + floor.calculateArea() + " sqf");
        System.out.println("Total Cost is: $" + cost);
        System.out.println("State Tax is: " + carpet.getSaleTax() + "% = " + taxes);
        System.out.println("Total: $" + (cost + taxes));
    }
}
