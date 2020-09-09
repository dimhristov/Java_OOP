package com.company.p3_WildFarm;

public class Tiger extends Feline {
    //private String livingRegion;

    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }


    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            throw new IllegalArgumentException(String.format("%s are not eating that type of food!", this.getClass().getSimpleName()));
        } else {
            super.setFoodEaten(food);
        }
    }


    @Override
    public void setLivingRegion(String livingRegion) {
        if (livingRegion == null) {
            throw new IllegalArgumentException(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
        }
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        return String.format("%s[%s, %.2f, %s, %d]", this.getClass().getSimpleName(), super.animalName, super.animalWeight, super.livingRegion, super.foodEaten);
    }
}
