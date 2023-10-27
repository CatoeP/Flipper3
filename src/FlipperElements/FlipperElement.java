package FlipperElements;

import Visitor.Visitor;

public abstract class FlipperElement {

    //HIer wird Visitor-Pattern (PointVisitor) & Command-Pattern (HitCommand) angewendet
    public abstract void accept(Visitor visitor);

    //Hier wird Command-Pattern (Hit-Command) angewendet
    public abstract int hit(int multiplier);

    //Hier wird Visitor-Pattern (ResetVisitor) & Command-Pattern (ResetCommand) angewendet
    public void reset(){}

    //per default true (bumper immer visible)
    public boolean getState(){
        return true;
    }

    public abstract String toString();

}
