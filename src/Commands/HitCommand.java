package Commands;

import FlipperElements.FlipperElement;
import Singleton.PinBallMachine;
import Visitor.PointVisitor;

public class HitCommand extends Command {
    PointVisitor pointVisitor = new PointVisitor(pinBallMachine);

    public HitCommand(FlipperElement element, PinBallMachine machine){
        super(element,machine);
        System.out.println("You hit a " + element.toString() + "!");
    }

    @Override
    public void execute() {
        flipperElement.accept(pointVisitor);
    }

}
