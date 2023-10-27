package Commands;

import FlipperElements.FlipperElement;
import Visitor.ResetVisitor;

public class ResetCommand extends Command{
    ResetVisitor resetVisitor = new ResetVisitor();

    public ResetCommand(FlipperElement element) {
        super(element);
    }

    @Override
    public void execute() {
        flipperElement.accept(resetVisitor);
    }
}
