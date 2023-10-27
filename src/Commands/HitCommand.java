package Commands;

import FlipperElements.FlipperElement;
import Visitor.PointVisitor;

public class HitCommand extends Command {
    PointVisitor pointVisitor = new PointVisitor();

    public HitCommand(FlipperElement element){
        super(element);
    }

    @Override
    public void execute() {
        flipperElement.accept(pointVisitor);
    }

}
