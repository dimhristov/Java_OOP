package CounterStriker.models.guns;

public class Rifle extends GunImpl {

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        int result = super.getBulletsCount() - 10;
        super.setBulletsCount(Math.max(result, 0));
        return 10;
    }
}
