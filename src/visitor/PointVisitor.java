package visitor;

import flipperElements.Bumper;
import flipperElements.Ramp;
import flipperElements.Target;
import singleton.PinBallMachine;

public class PointVisitor extends Visitor{
    private PinBallMachine pinBallMachine;

    public PointVisitor(PinBallMachine machine){
        pinBallMachine = machine;
    }

    @Override
    public void visit(Ramp ramp) {
        pinBallMachine.addPoints(ramp.hit(pinBallMachine.getMultiplier()));
    }

    @Override
    public void visit(Target target) {
        pinBallMachine.addPoints(target.hit(pinBallMachine.getMultiplier()));
    }

    @Override
    public void visit(Bumper bumper){
        pinBallMachine.addPoints(bumper.hit(pinBallMachine.getMultiplier()));
    }
}