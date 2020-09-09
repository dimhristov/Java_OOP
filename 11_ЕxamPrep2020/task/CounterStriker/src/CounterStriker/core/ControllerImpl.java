package CounterStriker.core;

import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.GunImpl;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;
import org.w3c.dom.css.Counter;

public class ControllerImpl implements Controller {

    private GunRepository guns;
    private PlayerRepository players;
    private Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        if (type.equals("Pistol")) {
            Gun gun = new Pistol(name, bulletsCount);
            guns.add(gun);
            return String.format("Successfully added gun %s.", gun.getName());
        } else if (type.equals("Rifle")) {
            Gun gun = new Rifle(name, bulletsCount);
            guns.add(gun);
            return String.format("Successfully added gun %s.", gun.getName());
        } else {
            throw new IllegalArgumentException("Invalid gun type.");
        }
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        if (type.equals("Terrorist")) {
            Player player = new Terrorist(username, health, armor, (Gun) guns.findByName(gunName));
            players.add(player);
            return String.format("Successfully added player %s.", username);
        } else if (type.equals("CounterTerrorist")) {
            Player player = new CounterTerrorist(username, health, armor, (Gun) guns.findByName(gunName));
            players.add(player);
            return String.format("Successfully added player %s.", username);
        } else {
            throw new IllegalArgumentException("Invalid player type!");
        }
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Object player : players.getModels()) {
            sb.append(player.toString().trim());
        }

        return sb.toString().trim();
    }
}
