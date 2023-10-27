package FlipperElements;

import Visitor.Visitor;

public class Target extends FlipperElement{

    private final int score = 30;
    boolean isVisible;

    public Target() {
        this.isVisible = false;
    }

    @Override
    public int hit() {
        System.out.println("A Target was hit. You received " + score + " points!");
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
        isVisible = true;
    }

    public void open() {
        isVisible = false;
    }
}
