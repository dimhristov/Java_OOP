package aquarium.core;

import aquarium.models.aquariums.Aquarium;
import aquarium.models.aquariums.FreshwaterAquarium;
import aquarium.models.aquariums.SaltwaterAquarium;
import aquarium.models.decorations.Decoration;
import aquarium.models.decorations.Ornament;
import aquarium.models.decorations.Plant;
import aquarium.models.fish.Fish;
import aquarium.models.fish.FreshwaterFish;
import aquarium.models.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;


    public ControllerImpl() {
        decorations = new DecorationRepository();
        aquariums = new ArrayList<>();
    }

    public Collection<Aquarium> getAquariums() {
        return aquariums;
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if (aquariumType.equals("FreshwaterAquarium")) {
            this.aquariums.add(new FreshwaterAquarium(aquariumName));
            return String.format("Successfully added %s.", aquariumType);
        } else if (aquariumType.equals("SaltwaterAquarium")) {
            this.aquariums.add(new SaltwaterAquarium(aquariumName));
            return String.format("Successfully added %s.", aquariumType);
        } else {
            throw new IllegalArgumentException("Invalid aquarium type.");
        }
    }

    @Override
    public String addDecoration(String type) {
        if (type.equals("Ornament")) {
            this.decorations.add(new Ornament());
            return String.format("Successfully added %s.", type);
        } else if (type.equals("Plant")) {
            this.decorations.add(new Plant());
            return String.format("Successfully added %s.", type);
        } else {
            throw new IllegalArgumentException("Invalid decoration type.");
        }
    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = null;
        if (decorations.findByType(decorationType) != null) {
            if (decorationType.equals("Ornament")) {
                decoration = new Ornament();
                this.decorations.remove(decorations.findByType(decorationType));
            } else if (decorationType.equals("Plant")) {
                decoration = new Plant();
                this.decorations.remove(decorations.findByType(decorationType));
            }
        } else {
            return String.format("There isn’t a decoration of type %s.", decorationType);
        }

        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                aquarium.addDecoration(decoration);

            }
        }
        return String.format("Successfully added %s to %s.", decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        if (fishType.equals("FreshwaterFish")) {
            fish = new FreshwaterFish(fishName, fishSpecies, price);
        } else if (fishType.equals("SaltwaterFish")) {
            fish = new SaltwaterFish(fishName, fishSpecies, price);
        } else {
            throw new IllegalArgumentException("Invalid fish type.");
        }

        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                if (aquarium instanceof FreshwaterAquarium) {
                    if (fish instanceof FreshwaterFish) {
                        if (((FreshwaterAquarium) aquarium).getCapacity() > 0) {
                            aquarium.addFish(fish);
                        } else {
                            throw new IllegalArgumentException("Not enough capacity.");
                        }
                    } else  {
                        throw new IllegalArgumentException("Water not suitable.");
                    }
                } else if (aquarium instanceof SaltwaterAquarium) {
                    if (fish instanceof SaltwaterFish) {
                        if (((SaltwaterAquarium) aquarium).getCapacity() > 0) {
                            aquarium.addFish(fish);
                        } else {
                            throw new IllegalArgumentException("Not enough capacity.");
                        }
                    } else  {
                        throw new IllegalArgumentException("Water not suitable.");
                    }

                }
            }

        }
        return String.format("Successfully added %s to %s.", fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        int count = 0;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                for (Fish fish : aquarium.getFish()) {
                    fish.eat();
                    count++;
                }
            }
        }
        return String.format("Fish fed: %d", count);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double sum = 0;
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getName().equals(aquariumName)) {
                for (Fish fish : aquarium.getFish()) {
                    sum += fish.getPrice();
                }
                for (Decoration decoration : aquarium.getDecorations()) {
                    sum += decoration.getPrice();
                }
            }
        }
        return String.format("The value of Aquarium %s is %.2f.", aquariumName, sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
