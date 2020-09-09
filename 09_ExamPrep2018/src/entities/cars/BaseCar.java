package entities.cars;

import contracts.Car;

public abstract class BaseCar implements Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected BaseCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    @Override
    public String toString() {
        StringBuilder car = new StringBuilder();

        car
                .append(String.format("%s %s %d", this.brand, this.model, this.yearOfProduction))
                .append(System.lineSeparator())
                .append(String.format("%s HP, 100 m/h in %d s", this.horsepower, this.acceleration))
                .append(System.lineSeparator())
                .append(String.format("%d Suspension force, %d Durability", this.suspension, this.durability))
                .append(System.lineSeparator());

        return car.toString();
    }
}
