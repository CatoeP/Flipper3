package Visitor;

import FlipperElements.Ramp;
import FlipperElements.Target;

public class ResetVisitor extends Visitor{
    @Override
    public void visit(Ramp ramp) {
        ramp.reset();
    }

    @Override
    public void visit(Target target) {
        target.reset();
    }

}
