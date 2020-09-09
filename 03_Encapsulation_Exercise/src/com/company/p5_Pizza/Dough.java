package com.company.p5_Pizza;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dough {
    private static final List<String> FLOUR_TYPES = List.of("White", "Wholegrain");
    private static final List<String> BACKING_TECHNIQUES = List.of("Crispy", "Chewy", "Homemade");

    private static final Map<String, Double> DOUGH_MODIFIERS = new HashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    private static final String INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE = "Invalid type of dough.";
    private static final String INVALID_WEIGHT_EXCEPTION_MESSAGE = "Dough weight should be in the range [1..200].";

    private String flourType;
    private String backingTechnique;
    private double weight;

    public Dough(String flourType, String backingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBackingTechnique(backingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!FLOUR_TYPES.contains(flourType)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE);
        }
        this.flourType = flourType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(INVALID_WEIGHT_EXCEPTION_MESSAGE);
        }
        this.weight = weight;
    }

    private void setBackingTechnique(String backingTechnique) {
        if (!BACKING_TECHNIQUES.contains(backingTechnique)) {
            throw new IllegalArgumentException(INVALID_TYPE_DOUGH_EXCEPTION_MESSAGE);
        }
        this.backingTechnique = backingTechnique;
    }

    public double calculateCalories() {
        return PizzaConstants.BASE_CALORIES * this.weight * DOUGH_MODIFIERS.get(this.flourType) * DOUGH_MODIFIERS.get(this.backingTechnique);
    }
}
