package aquarium.repositories;

import aquarium.models.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DecorationRepository implements Repository {
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        //TODO : Not sure if its right
        decorations = new ArrayList<>();
        //decorations = Collections.unmodifiableCollection(decorations);
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        return this.decorations.remove(decoration);
    }

    @Override
    public Decoration findByType(String type) {
        for (Decoration decoration : decorations) {
            if (decoration.getClass().getSimpleName().equalsIgnoreCase(type)) {
                return decoration;
            }
        }
        return null;
    }
}
