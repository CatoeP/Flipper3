package FlipperElements;
import Visitor.Visitor;

public class Ramp extends FlipperElement {

    private final int score = 50;
    private boolean isClosed;

    public Ramp() {
        this.isClosed = false;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hit() {
        System.out.println("A Ramp was hit. You received " + score + " points!");
        return score*multiplier;
    }

    public void reset() {
        open();
    }

    public void close() {
        isClosed = true;
    }

    public void open() {
        isClosed = false;
    }

    @Override
    public boolean getState(){
        return isClosed;
    }

    @Override
    public String toString(){
        return "Ramp";
    }
}

