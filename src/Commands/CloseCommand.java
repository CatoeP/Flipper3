package Commands;

import FlipperElements.FlipperElement;
import Visitor.CloseVisitor;

public class CloseCommand extends Command {
    CloseVisitor closeVisitor = new CloseVisitor();

    public CloseCommand(FlipperElement element){
        super(element);
    }

    @Override
    public void execute() {
        flipperElement.accept(closeVisitor);
    }

}
