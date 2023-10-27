package Visitor;

import FlipperElements.Bumper;
import FlipperElements.Ramp;
import FlipperElements.Target;

public class PointVisitor extends Visitor{
    @Override
    public void visit(Ramp ramp) {
        ramp.hit();
    }

    @Override
    public void visit(Target target) {
        target.hit();
    }

    @Override
    public void visit(Bumper bumper){
        bumper.hit();
    }
}
