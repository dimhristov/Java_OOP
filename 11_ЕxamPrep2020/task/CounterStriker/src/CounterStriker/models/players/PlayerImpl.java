package CounterStriker.models.players;

import CounterStriker.ValidationHelper;
import CounterStriker.models.guns.Gun;

public abstract class PlayerImpl implements Player {
    private String name;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    public PlayerImpl(String name, int health, int armor, Gun gun) {
        setName(name);
        setHealth(health);
        setArmor(armor);
        setGun(gun);
        isAlive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        ValidationHelper.validateNotNull(name,"Username cannot be null or empty.");
        this.name = name;
    }

    public void setHealth(int health) {
        ValidationHelper.validateInRange(health,"Player health cannot be below 0.");
        this.health = health;
    }

    public void setArmor(int armor) {
        ValidationHelper.validateInRange(armor,"Player armor cannot be below 0.");
        this.armor = armor;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException("Gun cannot be null.");
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public void takeDamage(int points) {
        armor = armor - points;

        if (armor <= 0) {
            int leftPoints = Math.abs(armor);
            this.setArmor(0);
            health = health - leftPoints;
        }
        if (health <= 0) {
            isAlive = false;
        }
    }

}
