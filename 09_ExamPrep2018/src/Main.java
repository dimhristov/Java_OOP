import contracts.CarManager;
import core.CarManagerImpl;
import engines.Engine;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        CarManager carManager = new CarManagerImpl();
        Engine engine = new Engine(inputReader,outputWriter,inputParser,carManager);
        engine.run();
    }
}
