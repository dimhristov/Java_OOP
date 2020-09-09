package com.company.p3_WildFarm;

public abstract class Mammal extends Animal {
    protected String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
