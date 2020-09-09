package CounterStriker.models.guns;

import CounterStriker.ValidationHelper;

public abstract class GunImpl implements Gun {
    public static final String GUN_CANT_BE_NULL_ERR_MESS = "Gun cannot be null or empty.";
    public static final String BULLETS_NOT_RANGE_ERR_MESS = "Bullets cannot be below 0.";
    private String name;
    private int bulletsCount;

    public GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    public void setName(String name) {
        ValidationHelper.validateNotNull(name, GUN_CANT_BE_NULL_ERR_MESS);
        this.name = name;
    }

    public void setBulletsCount(int bulletsCount) {
        ValidationHelper.validateInRange(bulletsCount, BULLETS_NOT_RANGE_ERR_MESS);
        this.bulletsCount = bulletsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return bulletsCount;
    }

    @Override
    public abstract int fire();

}
