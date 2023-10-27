package Commands;

import FlipperElements.FlipperElement;
import Singleton.PinBallMachine;

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
