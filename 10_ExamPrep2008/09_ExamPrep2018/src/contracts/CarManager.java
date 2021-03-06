package contracts;

public interface CarManager {
    void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability);

    String check(int id);

    void open(int id, String type, int length, String route, int prizePool);

    void participate(int carId, int raceId);
}
