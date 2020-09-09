package CounterStriker.repositories;

import CounterStriker.ValidationHelper;
import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository {
    private Collection<Gun> models;

    public GunRepository() {
        this.models = new ArrayList();
    }

    @Override
    public Collection getModels() {
        return this.models;
    }

    @Override
    public void add(Object model) {
        ValidationHelper.validateNotNull(model,"Cannot add null in Gun Repository");
        this.models.add((Gun)model);
    }

    @Override
    public boolean remove(Object model) {
        return this.models.remove(model);
    }

    @Override
    public Object findByName(String name) {

        for (Object model : models) {
            Gun gun = (Gun) model;
            if (gun.getName().equals(name)) {
                return gun;
            }
        }
        return null;
    }
}
