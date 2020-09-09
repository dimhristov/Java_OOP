package onlineShop.models.products;


import static onlineShop.models.products.ValidationHelper.*;

public abstract class BaseProduct implements Product {
    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;

    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        validateNotLessOrNotZero(id,"Id can not be less or equal than 0.");
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        validateNotNull(manufacturer,"Manufacturer can not be empty.");
        this.manufacturer = manufacturer;
    }

    private void setModel(String model) {
        validateNotNull(model,"Model can not be empty.");
        this.model = model;
    }

    private void setPrice(double price) {
        validateNotLessOrNotZero(price,"Price can not be less or equal than 0.");
        this.price = price;
    }

    private void setOverallPerformance(double overallPerformance) {
        validateNotLessOrNotZero(overallPerformance,"Overall Performance can not be less or equal than 0.");
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    @Override
    public String toString() {
        return String.format("Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                getOverallPerformance(), getPrice(), this.getClass().getSimpleName(), getManufacturer(), getModel(), getId());
    }
}
