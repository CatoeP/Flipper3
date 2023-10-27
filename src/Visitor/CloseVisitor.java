package Visitor;

import FlipperElements.Ramp;
import FlipperElements.Target;

public class CloseVisitor extends Visitor {

    @Override
    public void visit(Ramp ramp) {
        ramp.close();
    }

    @Override
    public void visit(Target target) {
        target.close();
    }
}
