package FlipperElements;

import Visitor.Visitor;

public class Target extends FlipperElement{

    private final int score = 30;
    boolean isVisible;

    public Target() {
        this.isVisible = true;
    }

    @Override
    public int hit(int multiplier) {
        System.out.println(score*multiplier + " Points");
        return score*multiplier;

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
