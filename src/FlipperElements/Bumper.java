package FlipperElements;

import Visitor.Visitor;

public class Bumper extends FlipperElement{

    private final int score = 10;

    @Override
    public int hit() {
        System.out.println("A Bumper was hit. You received " + score + " points!");
        return score*multiplier;
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
