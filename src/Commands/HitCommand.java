package Commands;

import FlipperElements.FlipperElement;

public class HitCommand implements Command {
    private FlipperElement element;

    public HitCommand(FlipperElement element) {
        this.element = element;
    }

    @Override
    public void execute() {
        element.hit();
    }

}
