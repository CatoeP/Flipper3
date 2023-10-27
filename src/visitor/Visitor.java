package visitor;

import flipperElements.Bumper;
import flipperElements.Ramp;
import flipperElements.Target;

public abstract class Visitor {
    public abstract void visit(Ramp ramp);
    public abstract void visit(Target target);
    public void visit(Bumper bumper){}
}
