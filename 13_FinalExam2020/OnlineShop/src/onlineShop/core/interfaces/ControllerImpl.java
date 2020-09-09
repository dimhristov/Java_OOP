package onlineShop.core.interfaces;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private Collection<Component> components;
    private Collection<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer = null;
        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }

        for (Computer comp : computers) {
            if (comp.getId() == computer.getId()) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }
        this.computers.add(computer);
        return String.format("Computer with id %d added successfully.", computer.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        checkIfComputerExist(computerId);
        Peripheral peripheral = null;
        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        Computer searchingComputer = findComputer(computerId);
        searchingComputer.addPeripheral(peripheral);
        this.peripherals.add(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    private Computer findComputer(int computerId) {
        checkIfComputerExist(computerId);
        //Computer comp = this.computers.stream().;



        for (Computer comp : this.computers) {
            if (comp.getId() == computerId) {
                return comp;
            }
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }


    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkIfComputerExist(computerId);
        Computer searchingComputer = findComputer(computerId);
        Peripheral per = searchingComputer.removePeripheral(peripheralType);
        this.peripherals.remove(per);
        return String.format(OutputMessages.REMOVED_PERIPHERAL, peripheralType, per.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checkIfComputerExist(computerId);

        Component component = null;
        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }
//        if (this.components.contains(component)) {
//            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
//        }
        for (Component comp : components) {
            if (comp.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }
        this.components.add(component);
        // tuk slagam komponena i v kolekciqta s komputri TODO
        for (Computer comp : computers) {
            if (comp.getId() == computerId) {
                comp.addComponent(component);
            }
        }
        return String.format(OutputMessages.ADDED_COMPONENT, componentType, id, computerId);

    }

    private void checkIfComputerExist(int computerId) {

        boolean isPresent= this.computers.stream().anyMatch(c -> c.getId() == computerId);
//        for (Computer comp : this.computers) {
//            if (comp.getId() == computerId) {
//                isPresent = true;
//            }
//        }
        if (!isPresent) {
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkIfComputerExist(computerId);
        Component removedComponennt=null;
        for (Computer comp : computers) {
            if (comp.getId() == computerId) {
                removedComponennt=comp.removeComponent(componentType);
            }
        }
        this.components.remove(removedComponennt);
        return String.format(OutputMessages.REMOVED_COMPONENT, componentType, removedComponennt.getId());

    }

    @Override
    public String buyComputer(int id) {
        checkIfComputerExist(id);
        Computer computer = findComputer(id);
        this.computers.remove(computer);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        boolean enoughMoney= false;
        for (Computer comp : computers) {
            if (comp.getPrice() <= budget) {
                enoughMoney = true;
            }
        }
        if (computers.isEmpty() || !enoughMoney) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER, budget));
        }
        List<Computer> sortedComputers = computers.stream()
                .sorted(Comparator.comparingDouble(Product::getOverallPerformance))
                .filter(c -> c.getPrice() <= budget)
                .collect(Collectors.toList());
        Computer bestComputer = sortedComputers.get(sortedComputers.size() - 1);
        this.computers.remove(bestComputer);
        return bestComputer.toString();

    }

    @Override
    public String getComputerData(int id) {
        Computer comp = findComputer(id);
        return comp.toString();
    }
}
