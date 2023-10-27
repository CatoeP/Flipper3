package Commands;

import FlipperElements.FlipperElement;
import Singleton.PinBallMachine;

import java.util.ArrayList;
import java.util.List;

public class MakroCommand extends Command{

    private List<Command> commands = new ArrayList<>();


    public void addCommand(Command command) {
        commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

}
