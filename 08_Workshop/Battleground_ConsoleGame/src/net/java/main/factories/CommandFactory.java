package net.java.main.factories;

import net.java.main.enums.CommandType;
import net.java.main.interfaces.Command;

public  class CommandFactory {



    public Command createCommand(CommandType type) {
        switch (type) {
            case MOVE:
                //return new MoveCommand();

            case FIGHT:
                //return new FightCommad();

            case STATUS:
                //return new StatusCommad();

            case SPAWN:
               // return new SpawnCommand();

            case GAME_OVER:
                //return new GammeOverCommand();
            default : return null;
        }
    }
}
