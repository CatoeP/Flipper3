package Commands;

import FlipperElements.FlipperElement;

public abstract class Command {
    protected FlipperElement flipperElement;

    //wegen makrocommand notwendig
    public Command(){}

    public Command(FlipperElement element){
        flipperElement =element;
    }

    public abstract void execute();
}
