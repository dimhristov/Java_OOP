package entities.races;

import contracts.Car;

import java.util.Collection;

public class DriftRace extends BaseRace {

    public DriftRace(int length, String route, int prizePool, Collection<Car> participants) {
        super(length, route, prizePool, participants);
    }
}
