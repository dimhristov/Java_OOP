package com.company.p3_WildFarm;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, Double animalWeight, String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    protected void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.setFoodEaten(food);
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %s, %.2f,%s, %d]",this.getClass().getSimpleName(),super.animalName,this.breed,super.animalWeight,super.livingRegion,super.foodEaten);
    }
}
