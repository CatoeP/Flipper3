package states;

import singleton.PinBallMachine;

public class ReadyState extends State {

    public ReadyState(PinBallMachine machine){
        super(machine);
  }

    @Override
    public void pressStartButton() {
        System.out.println("Starting the game...");
    }

    @Override
    public void info() {
        System.out.println("Your game is ready! Type 's' to play.");

    }
}
