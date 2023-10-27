package FlipperElements;
import Visitor.Visitor;

public class Ramp extends FlipperElement {

    private boolean isOpen;

    public Ramp() {
        super(50);
        this.isOpen = true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void reset() {
        open();
    }

    public void close() {
        isOpen = false;
    }

    public void open() {
        isOpen = true;
    }

    @Override
    public boolean getState(){
        return isOpen;
    }

    @Override
    public String toString(){
        return "Ramp";
    }
}

