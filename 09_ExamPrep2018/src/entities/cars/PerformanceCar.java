package entities.cars;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends BaseCar {
    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder performanceCar = new StringBuilder(super.toString());

        String addOns = this.addOns.size() ==0 ? "None": String.join(",",this.addOns);

        performanceCar
                .append(String.format("Add-ons: %s",addOns));

        return performanceCar.toString();
    }
}
