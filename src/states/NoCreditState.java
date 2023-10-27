package states;

import singleton.PinBallMachine;

public class NoCreditState extends State {

    public NoCreditState(PinBallMachine machine){
        super(machine);
    }

    @Override
    public void pressStartButton() {
        System.out.println("No credits. Please insert coins.");
    }

    public void info(){
        System.out.println("No credits. Please insert coins by typing 'c'.\nYou can insert coins anytime.");
    }
}
