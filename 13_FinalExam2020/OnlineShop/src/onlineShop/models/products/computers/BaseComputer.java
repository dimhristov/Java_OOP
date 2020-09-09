package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.components.Motherboard;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    //TODO: check if this must be super or this
    @Override
    public double getOverallPerformance() {
        double compPerformance = super.getOverallPerformance();
        if (this.components.isEmpty()) {
            return compPerformance;
        } else {
            double componentsSum = 0;
            int count = 0;
            for (Component component : components) {
                componentsSum += component.getOverallPerformance();
                count++;
            }
            return compPerformance + componentsSum / count;
        }
    }

    @Override
    public double getPrice() {
        double totalSum = super.getPrice();
        for (Component component : components) {
            totalSum += component.getPrice();
        }
        for (Peripheral peripheral : peripherals) {
            totalSum += peripheral.getPrice();
        }
        return totalSum;
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.getPeripherals();
    }

    @Override
    public void addComponent(Component component) {
        if (this.components.contains(component)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    component.getClass().getSimpleName(),
                    this.getClass().getSimpleName(),
                    super.getId()));
        }
        this.components.add(component);
    }

    //TODO check the stream
    @Override
    public Component removeComponent(String componentType) {
        //boolean isPresent = this.components.stream().anyMatch(c -> c.getClass().getSimpleName().equals(componentType));
        boolean isPresent=false;
        for (Component component : components) {
            if (component.getClass().getSimpleName().equalsIgnoreCase(componentType)) {
                isPresent= true;
                break;
            }
        }
        if (this.components.isEmpty() || !isPresent) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                    componentType,
                    super.getClass().getSimpleName(),
                    super.getId()));
        }

        Component copyComponnent = null;
        for (Component component : components) {
            copyComponnent = component;
            if (component.getClass().getSimpleName().equals(componentType)) {
                this.components.remove(component);
                break;
            }
        }
        return copyComponnent;

    }


    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (this.peripherals.contains(peripheral)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    super.getClass().getSimpleName(),
                    super.getId()));
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        //boolean isPresent = this.peripherals.stream().anyMatch(p -> p.getClass().getSimpleName().equals(peripheralType));
        boolean isPresent=false;
        for (Peripheral peripheral : peripherals) {
            if (peripheral.getClass().getSimpleName().equalsIgnoreCase(peripheralType)) {
                isPresent= true;
            }
        }
        if (this.peripherals.isEmpty() || !isPresent) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                    peripheralType,
                    super.getClass().getSimpleName(),
                    super.getId()));
        }

        Peripheral copyPeripheral = null;
        for (Peripheral peripheral : peripherals) {
            copyPeripheral = peripheral;
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                this.peripherals.remove(peripheral);
                break;
            }
        }
        return copyPeripheral;

    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        sb.append(super.toString());
        sb.append(System.lineSeparator());
        sb.append(String.format(" Components (%d):", this.components.size()));
        sb.append(System.lineSeparator());
        for (Component component : components) {
            sb.append("  " + component.toString());
            sb.append(System.lineSeparator());
        }
        sb.append(String.format(" Peripherals (%d); Average Overall Performance (%.2f):", this.peripherals.size(), this.getOverallPerformance()));
        sb.append(System.lineSeparator());
        for (Peripheral per : peripherals) {
            sb.append("  " + per.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }


}

