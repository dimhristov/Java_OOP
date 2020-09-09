package entities.races;

import contracts.Car;
import contracts.Race;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRace implements Race {
    private int length;
    private String route;
    private int prizePool;
    private Collection<Car> participants;

    protected BaseRace(int length, String route, int prizePool, Collection<Car> participants) {
        this.length = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = participants;
        this.participants = new ArrayList<>();
    }
}
