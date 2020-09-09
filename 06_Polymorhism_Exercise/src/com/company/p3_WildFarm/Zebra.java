package com.company.p3_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            super.setFoodEaten(food);
        } else {
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", this.getClass().getSimpleName()));
        }
    }


    @Override
    public String toString() {
        return String.format("%s[%s, %.2f, %s, %d]", this.getClass().getSimpleName(), super.animalName, super.animalWeight, super.livingRegion, super.foodEaten);
    }
}
