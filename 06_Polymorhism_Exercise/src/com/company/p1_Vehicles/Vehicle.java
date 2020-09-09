package com.company.p1_Vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKm;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumptionPerKm(fuelConsumptionPerKm);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumptionPerKm(double fuelConsumptionPerKm) {
        this.fuelConsumptionPerKm = fuelConsumptionPerKm;
    }

    public boolean drive(double distance) {
        double neededFuel = distance * this.fuelConsumptionPerKm;
        if (this.fuelQuantity < neededFuel) {
            return false;
        }
        this.fuelQuantity -=neededFuel;
        return true;
    }

    public void refuel(double liters) {
        this.fuelQuantity +=liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }
}
