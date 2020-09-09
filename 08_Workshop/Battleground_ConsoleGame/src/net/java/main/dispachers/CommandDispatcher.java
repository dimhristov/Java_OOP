package net.java.main.dispachers;

import net.java.main.commands.CommandImpl;
import net.java.main.enums.CommandType;
import net.java.main.exceptions.GameException;
import net.java.main.factories.CommandFactory;
import net.java.main.interfaces.Command;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static net.java.main.enums.CommandType.*;

public class CommandDispatcher {
    private Map<String, Command> commands;
    private CommandFactory commandFactory;
    //TODO add battleField

    public CommandDispatcher() {
        this.commands = new HashMap<>();
        this.commandFactory = new CommandFactory();
        this.seedCommands();
    }

    public String dispatchCommand(String[] args) throws GameException {
        if (this.commands.containsKey(args[0])) {
            return this.commands.get(args[0]).execute(args);
        }
        throw new GameException("Invalid command");
    }
    private void seedCommands() {
        commands.put(CommandType.SPAWN.toString(), this.commandFactory.createCommand(CommandType.SPAWN));
        commands.put(CommandType.FIGHT.toString(), this.commandFactory.createCommand(CommandType.FIGHT));
        commands.put(CommandType.MOVE.toString(), this.commandFactory.createCommand(CommandType.MOVE));
        commands.put(CommandType.STATUS.toString(), this.commandFactory.createCommand(CommandType.STATUS));
        commands.put(CommandType.GAME_OVER.toString(), this.commandFactory.createCommand(CommandType.GAME_OVER));
    }
}
