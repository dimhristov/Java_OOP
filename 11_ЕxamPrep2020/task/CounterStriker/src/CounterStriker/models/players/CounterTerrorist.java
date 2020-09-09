package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

public class CounterTerrorist extends PlayerImpl{

    public CounterTerrorist(String name, int health, int armor, Gun gun) {
        super(name, health, armor, gun);
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                "--Health: %d%n" +
                "--Armor: %d%n" +
                "--Gun: %s", CounterTerrorist.class.getSimpleName(), getName(),getHealth(),getArmor(),getGun().getName());
    }
}
