package core;

import contracts.Car;
import contracts.CarManager;
import contracts.Race;
import entities.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManagerImpl implements CarManager {
    private static final String PERFORMANCE_CAR_TYPE = "Performance";
    private static final String SHOW_CAR_TYPE = "Show";
    private Map<Integer, Car> carMap;
    private Map<Integer,Race> ongoingRaces;

    public CarManagerImpl(Map<Integer, Car> carMap) {
        this.carMap = new LinkedHashMap<>();
    }

    public CarManagerImpl() {
        this.carMap = new LinkedHashMap<>();
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
            this.carMap.put(id,car);
        }
    }
   @Override
    public String check(int id) {
       System.out.println(this.carMap.get(id).toString());
        return this.carMap.get(id).toString();
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = null;
        switch (type) {
            case "Casual":
                race = new CasualRace(length,route,prizePool);
                this.ongoingRaces.put(id, race);
                break;
            case "Drag":
                race = new DragRace(length,route,prizePool);
                this.ongoingRaces.put(id, race);
                break;
            case "Drift":
                race = new DriftRace(length,route,prizePool);
                this.ongoingRaces.put(id, race);
                break;
        }
    }
    @Override
    public void participate(int carId, int raceId) {

    }
}
