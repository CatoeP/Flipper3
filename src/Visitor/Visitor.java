package Visitor;

import FlipperElements.Bumper;
import FlipperElements.Ramp;
import FlipperElements.Target;

public abstract class Visitor {
    public abstract void visit(Ramp ramp);
    public abstract void visit(Target target);
    public void visit(Bumper bumper){}
}
