package com.company.p2_CarShop;

import java.io.Serializable;

public class Seat implements Serializable,Car {
    private String countryProduced;
    private String model;
    private String color;
    private Integer horsePower;

    public Seat(String model, String color, Integer horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower=horsePower;
        this.countryProduced = countryProduced;
    }


    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public Integer getHorsePower() {
        return this.horsePower;
    }

    @Override
    public String toString() {
        return String.format("This is %s produced in %s and have %s tires",this.getModel(),this.getCountryProduced(),TIRES);
    }

    private String getCountryProduced() {
        return this.countryProduced;
    }
}
