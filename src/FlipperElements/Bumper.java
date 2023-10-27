package FlipperElements;

import Visitor.Visitor;

public class Bumper extends FlipperElement{

    public Bumper(){
        super(10);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString(){
        return "Bumper";
    }
}
