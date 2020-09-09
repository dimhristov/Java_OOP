package com.company.p3_WildFarm;

public class Mouse extends Mammal {


    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {

    }

    // if the food is vegetable the mouse will eat it
    public void eat(Vegetable vegetable) {
        super.setFoodEaten(vegetable);
    }

    // if the food is meat it won't
    public void eat(Meat meat) {
        throw new IllegalArgumentException(String.format("%s are not eating that type of food!", this.getClass().getSimpleName()));
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.2f, %s, %d]", this.getClass().getSimpleName(), super.animalName, super.animalWeight, super.livingRegion, super.foodEaten);
    }
}
