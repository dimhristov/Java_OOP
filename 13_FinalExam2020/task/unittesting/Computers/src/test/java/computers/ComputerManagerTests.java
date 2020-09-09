
package computers;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class ComputerManagerTests {
    // TODO: Test ComputerManager


    @Test
    public  void addComputerShouldAdd() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        Computer comp = manager.getComputer("manufac", "models");
        assertEquals(comp, computer);
    }

    @Test
    public  void getCountShoudReturnCount() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        int ocunt = manager.getCount();
        assertEquals(ocunt  , 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void addComputerShouldThrowWxception() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        manager.addComputer(computer);
    }

    @Test
    public  void removeCompShoudRemove() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        manager.removeComputer("manufac", "models");

        assertEquals(0, manager.getCount());
    }

    @Test
    public  void getComputerShouldReturnComputer() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        Computer comp = manager.getComputer("manufac", "models");
        assertEquals(comp, computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public  void getComputerShouldThrowException() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);

        Computer comp = manager.getComputer("manufac", "models");

    }

    @Test
    public  void getComputerByManufacturerShouldReturnthem() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        Computer computer1 = new Computer("manufa2", "models", 12);
        Computer computer2   = new Computer("manufac", "models2", 14);
        manager.addComputer(computer);
        manager.addComputer(computer1);
        manager.addComputer(computer2);
        List<Computer> expected = manager.getComputersByManufacturer("manufac");
        assertEquals(2, expected.size());
    }
    @Test(expected = IllegalArgumentException.class)
    public  void addComputerShouldthrowNull() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public  void getComputerShouldReturnUnmodifieble() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        Computer compute2 = new Computer("manufacs", "modelds", 12);
        manager.addComputer(computer);
        manager.getComputers().add(compute2);
    }
    @Test
    public  void constructorShould() {
        ComputerManager manager = new ComputerManager();
        int expected = manager.getCount();
        assertEquals(0, expected);
    }
    @Test
    public  void constructorShould2() {
        ComputerManager manager = new ComputerManager();
        Computer computer = new Computer("manufac", "models", 12);
        manager.addComputer(computer);
        int expected = manager.getCount();
        assertEquals(1, expected);
    }

}