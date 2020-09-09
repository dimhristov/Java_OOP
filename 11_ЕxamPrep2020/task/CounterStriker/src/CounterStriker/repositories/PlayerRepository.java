package CounterStriker.repositories;

import CounterStriker.ValidationHelper;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

public class PlayerRepository implements Repository{
    private Collection<Player> models;

    public PlayerRepository() {
        this.models = new LinkedList<>();
    }

    @Override
    public Collection getModels() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        ValidationHelper.validateNotNull(model,"Cannot add null in Player Repository");
        models.add((Player)model);
    }

    @Override
    public boolean remove(Object model) {
        return models.remove(model);
    }

    @Override
    public Object findByName(String name) {
        for (Player model : models) {
            if (model.getUsername().equals(name)) {
                return model;
            }
        }
        return null;
    }
}
