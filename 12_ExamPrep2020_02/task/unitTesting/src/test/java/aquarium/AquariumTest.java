package aquarium;

import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTest {

    @Test(expected = NullPointerException.class)
    public void setName_ShoudThrow_Exception_When_InvalidInput() {
        Aquarium testAqua = new Aquarium("", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacity_ShoudThrow_Exception_When_InvalidInput() {
        Aquarium testAqua = new Aquarium("10", -1);
    }

    @Test
    public void getCapacity_ShoudWork() {
        Aquarium testAqua = new Aquarium("10", 2);
        assertEquals(testAqua.getCapacity(),2);
    }

    @Test
    public void getName_ShoudWork() {
        Aquarium testAqua = new Aquarium("10", 2);
        assertEquals(testAqua.getName(),"10");
    }

    @Test
    public void getCount_ShoudWork() {
        Aquarium testAqua = new Aquarium("10", 2);
        testAqua.add(new Fish("Nemo"));
        assertEquals(testAqua.getCount(),1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFish_Shoud_Throw_exception() {
        Aquarium testAqua = new Aquarium("10", 1);
        testAqua.add(new Fish("Nemo"));
        testAqua.add(new Fish("Nem2o"));
    }

    @Test
    public void removeFish_Shoud_Work() {
        Aquarium testAqua = new Aquarium("10", 3);
        testAqua.add(new Fish("Nemo"));
        testAqua.add(new Fish("Nem2o"));
        testAqua.remove("Nemo");
        assertEquals(testAqua.getCount(), 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFish_Shoud_ThrowException() {

        Aquarium testAqua = new Aquarium("10", 3);
        testAqua.add(new Fish("Nemo3"));
        testAqua.add(new Fish("Nem2o"));
        testAqua.remove("Nemo");

    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFish_Shoud_ThrowException() {

        Aquarium testAqua = new Aquarium("10", 3);
        testAqua.add(new Fish("Nemo3"));
        testAqua.add(new Fish("Nem2o"));
        testAqua.sellFish("Nemo");

    }

    @Test
    public void sellFish_Shoud_Work() {
        Fish fish = new Fish("Nemo");
        Aquarium testAqua = new Aquarium("10", 3);
        testAqua.add(fish);
        testAqua.sellFish("Nemo");
        assertFalse(fish.isAvailable());
    }





}