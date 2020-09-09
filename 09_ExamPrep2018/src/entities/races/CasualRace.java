package entities.races;

import contracts.Car;

import java.util.Collection;

public class CasualRace extends BaseRace {

    public CasualRace(int length, String route, int prizePool, Collection<Car> participants) {
        super(length, route, prizePool, participants);
    }
}
