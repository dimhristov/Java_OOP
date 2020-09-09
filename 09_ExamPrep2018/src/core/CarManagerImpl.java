package core;

import contracts.Car;
import contracts.CarManager;
import entities.cars.PerformanceCar;
import entities.cars.ShowCar;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManagerImpl implements CarManager {
    private static final String PERFORMANCE_CAR_TYPE = "Performance";
    private static final String SHOW_CAR_TYPE = "Show";

    private Map<Integer, Car> cars;

    public CarManagerImpl(Map<Integer, Car> cars) {
        this.cars = new LinkedHashMap<>();
    }

    @Override
    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = null;
        switch (type) {
            case PERFORMANCE_CAR_TYPE:
                car = new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
            case SHOW_CAR_TYPE:
                car = new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
                break;
        }
        if (car != null) {
            this.cars.put(id,car);
        }
    }
    @Override
    public String check(int id) {
        return this.cars.get(id).toString();

    }

    public void open(int id, String type, int length, String route, int prizePool) {

    }

    public void participate(int carId, int raceId) {

    }

    public String start(int id) {
        return null;

    }

    public void park(int id) {

    }

    public void unpark(int id) {

    }

    public void tune(int tuneIndex, String addOn) {

    }

}
