package aquarium.models.fish;

import aquarium.ValidationHelper;

public abstract class BaseFish implements Fish {

    private String name;
    private String species;
    private int size;
    private double price;

    protected BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }


    @Override
    public void setName(String name) {
        ValidationHelper.validateNotNullOrWhiteSpace(name, "Fish name cannot be null or empty.");
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    private void setSpecies(String species) {
        ValidationHelper.validateNotNullOrWhiteSpace(species,"Fish species cannot be null or empty.");
        this.species = species;
    }

    protected void setSize(int size) {
        //TODO : moje bi moje da ima validationhelper i tuk
        this.size = size;
    }

    private void setPrice(double price) {
        ValidationHelper.validateIfNegativeOrZero(price,"Fish price cannot be below or equal to 0.");
        this.price = price;
    }

    @Override
    public  void eat() {
        this.size += 5;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
