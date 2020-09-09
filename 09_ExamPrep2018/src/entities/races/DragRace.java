package entities.races;

import contracts.Car;

import java.util.Collection;

public class DragRace extends BaseRace {

    protected DragRace(int length, String route, int prizePool, Collection<Car> participants) {
        super(length, route, prizePool, participants);
    }
}
