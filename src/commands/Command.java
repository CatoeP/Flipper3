package commands;

import flipperElements.FlipperElement;
import singleton.PinBallMachine;

public abstract class Command {
    protected FlipperElement flipperElement;
    protected PinBallMachine pinBallMachine;

    //wegen makrocommand
    public Command(){

    }

    public Command(FlipperElement element, PinBallMachine machine){
        flipperElement =element;
        pinBallMachine=machine;
    }

    public abstract void execute();

}
