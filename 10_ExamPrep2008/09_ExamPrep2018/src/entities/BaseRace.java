package entities;

import contracts.Car;
import contracts.Race;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseRace implements Race {
    private int length;
    private String route;
    private int prizePool;
    private Collection<Car> cars;



    public BaseRace(int length, String route, int prizePool) {

        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.cars = new ArrayList<>();
    }
}
