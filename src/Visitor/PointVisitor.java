package Visitor;

import FlipperElements.Bumper;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Singleton.PinBallMachine;

public class PointVisitor extends Visitor{
    private PinBallMachine pinBallMachine;

    public PointVisitor(PinBallMachine machine){
        pinBallMachine = machine;
    }

    @Override
    public void visit(Ramp ramp) {
        pinBallMachine.addPoints(ramp.hit());
    }

    @Override
    public void visit(Target target) {
        pinBallMachine.addPoints(target.hit());
    }

    @Override
    public void visit(Bumper bumper){
        pinBallMachine.addPoints(bumper.hit());
    }
}
