package com.company.p3_WildFarm;

public abstract class Animal {
    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected Integer foodEaten = 0;

    public  Animal(){

    }

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
    }

    protected void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    protected void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    protected void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    protected void setFoodEaten(Food foodEaten) {
        int foodQuantity = foodEaten.getQuantity();
        this.foodEaten += foodQuantity;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);

    @Override
    public String toString() {
        return super.toString();
    }
}
