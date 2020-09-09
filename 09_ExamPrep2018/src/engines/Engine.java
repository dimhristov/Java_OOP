package engines;

import contracts.CarManager;
import core.CarManagerImpl;
import io.ConsoleInputReader;
import io.ConsoleOutputWriter;
import utilities.InputParser;

import java.util.List;

public class Engine {
    private static final String TERMINATE_COMMAND = "Cops Are Here";
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private CarManager carManager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.carManager = carManager;
    }

    public void run() {
        String inputLine;

        while (true) {
            inputLine = this.inputReader.readLine();
            List<String> commandParams = this.inputParser.parseInput(inputLine);

            this.dispatchCommand(commandParams);
            //INPUT_TERMINATING_COMMAND - this is the command that will terminate the program
            if (inputLine.equals(TERMINATE_COMMAND)) {
                break;
            }
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        int id;
        switch (command) {
            case "register":
                id = Integer.parseInt(commandParams.get(1));
                String type = commandParams.get(2);
                String brand = commandParams.get(3);
                String model = commandParams.get(4);
                int year = Integer.parseInt(commandParams.get(5));
                int horsepower = Integer.parseInt(commandParams.get(6));
                int acceleration = Integer.parseInt(commandParams.get(7));
                int suspension = Integer.parseInt(commandParams.get(8));
                int durability = Integer.parseInt(commandParams.get(9));
                this.carManager.register(id,type,brand,model,year,horsepower,acceleration,suspension,durability);
            case "check":
                id = Integer.parseInt(commandParams.get(1));
                this.carManager.check(id);
                break;
        }
    }
}
