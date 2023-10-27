package Commands;

import FlipperElements.FlipperElement;
import Singleton.PinBallMachine;
import Visitor.ResetVisitor;

public class ResetCommand extends Command{
    ResetVisitor resetVisitor = new ResetVisitor();

    public ResetCommand(FlipperElement element, PinBallMachine machine) {
        super(element,machine);
    }

    @Override
    public void execute() {
        flipperElement.accept(resetVisitor);
    }
}
