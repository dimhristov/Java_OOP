package com.company.p1_Vehicles;

public class Car extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm);
    }

    @Override
    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        super.setFuelConsumptionPerKm(fuelConsumptionPerKm + SUMMER_MODE_PERMANENT_ON);
    }
}
