package com.company.p1_Vehicles;

public class Truck extends Vehicle {
    private static final double SUMMER_MODE_PERMANENT_ON = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionPerKm) {
        super(fuelQuantity, fuelConsumptionPerKm+ SUMMER_MODE_PERMANENT_ON);
    }

    @Override
    public void refuel(double liters) {

        super.refuel(liters * 0.95);
    }
}
