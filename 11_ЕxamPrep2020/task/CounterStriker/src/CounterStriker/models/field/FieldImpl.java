package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terroristList = new ArrayList<>();
        List<Player> counterTerroristList = new ArrayList<>();

        for (Player player : players) {
            if (player instanceof Terrorist) {
                terroristList.add(player);
            } else {
                counterTerroristList.add(player);
            }
        }
        while (terroristList.stream().allMatch(Player::isAlive) && counterTerroristList.stream().allMatch(Player::isAlive)) {

            for (Player terrorist : terroristList) {
                for (Player ct : counterTerroristList) {
                    ct.takeDamage(terrorist.getGun().fire());
                }
            }

            counterTerroristList = counterTerroristList
                    .stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());

            for (Player ct : counterTerroristList) {
                for (Player terorist : terroristList) {
                    terorist.takeDamage(ct.getGun().fire());
                }
            }
            terroristList = terroristList
                    .stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());
        }
        if (counterTerroristList.isEmpty()) {
            return OutputMessages.TERRORIST_WINS;
        } else {
            return OutputMessages.TERRORIST_WINS;
        }
    }
}
