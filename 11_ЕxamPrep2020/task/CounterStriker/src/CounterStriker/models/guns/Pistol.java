package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int result = super.getBulletsCount() - 1;
        super.setBulletsCount(Math.max(result, 0));
        return 1;
    }
}
