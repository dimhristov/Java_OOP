package entities;

import java.util.ArrayList;
import java.util.Collection;

public class PerformanceCar extends BaseCar {

    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.addOns = new ArrayList<>();
        super.setHorsepower(horsepower + (50 * horsepower) / 100);
        super.setSuspension(suspension - (suspension * 25) / 100);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        String addOns = this.addOns.size() == 0 ? "None" : String.join(",",this.addOns);
        return sb.toString();
    }
}
