package States;

import Singleton.PinBallMachine;

public abstract class State {

    protected PinBallMachine machine;

    public State(PinBallMachine machine){
        this.machine = machine;
    }

    public abstract void pressStartButton();

    public abstract void info();

}
