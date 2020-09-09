package aquarium.models.aquariums;

import aquarium.ValidationHelper;
import aquarium.models.decorations.Decoration;
import aquarium.models.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name) {
        this.setName(name);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        ValidationHelper.validateNotNullOrWhiteSpace(name, AQUARIUM_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setDecorations(Collection<Decoration> decorations) {
        this.decorations = decorations;
    }

    private void setFish(Collection<Fish> fish) {
        this.fish = fish;
    }

    @Override
    public int calculateComfort() {
        //TODO: check if its working
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() < capacity) {
            this.fish.add(fish);
            this.capacity--;
        } else {
            throw new IllegalArgumentException("Not enough capacity.");
        }
    }

    @Override
    public void removeFish(Fish fish) {
        if (this.fish.contains(fish)) {
            this.fish.remove(fish);
            this.capacity++;
        }
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish oneFish : fish) {
            oneFish.eat();
        }
    }

    @Override
    public String getInfo() {
        //TODO: check if the space is wokring
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        sb.append("Fish: ");
        if (this.fish.isEmpty()) {
            sb.append( "none");
        }else {
            for (Fish fish1 : fish) {
                sb.append(fish1.getName() + " ");
            }
        }

        sb.append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", this.decorations.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Comfort: %d", this.calculateComfort()));
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
