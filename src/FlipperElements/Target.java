package FlipperElements;

import Visitor.Visitor;

public class Target extends FlipperElement{

    boolean isVisible;

    public Target() {
        super(30);
        this.isVisible = true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void reset() {
        open();
    }

    @Override
    public boolean getState(){
        return isVisible;
    }

    public void close() {
        isVisible = false;
    }

    public void open() {
        isVisible = true;
    }

    @Override
    public String toString(){
        return "Target";
    }
}
