package Commands;

import FlipperElements.FlipperElement;
import Singleton.PinBallMachine;
import Visitor.CloseVisitor;

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
