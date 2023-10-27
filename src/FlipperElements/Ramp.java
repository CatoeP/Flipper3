package FlipperElements;
import Visitor.Visitor;

public class Ramp extends FlipperElement {

    private final int score = 50;
    private boolean isOpen;

    public Ramp() {
        this.isOpen = true;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public int hit(int multiplier) {
        System.out.println(score*multiplier + " Points");
        return score*multiplier;

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

