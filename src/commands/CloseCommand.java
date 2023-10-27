package commands;

import flipperElements.FlipperElement;
import singleton.PinBallMachine;
import visitor.CloseVisitor;

public class CloseCommand extends Command {
    CloseVisitor closeVisitor = new CloseVisitor();

    public CloseCommand(FlipperElement element, PinBallMachine machine){
        super(element, machine);
    }

    @Override
    public void execute() {
        flipperElement.accept(closeVisitor);
    }

}
