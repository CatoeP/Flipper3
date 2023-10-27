package FlipperElements;

import Visitor.Visitor;

public class Bumper extends FlipperElement{

    private final int score = 10;

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
    public String toString(){
        return "Bumper";
    }
}
