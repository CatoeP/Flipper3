package Singleton;

import States.State;

public class PinBallMachine {

    private State currentState;
    private static PinBallMachine instance = null;

    //Singleton: Sicherstellen, dass von PinballMachine nur eine Instanz existiert
    public static PinBallMachine getInstance() {
        if (instance == null) {
            instance = new PinBallMachine();
        }
        return instance;
    }

    public void setState(State state){
        currentState = state;
        state.info();
    }

    public State getState(){
        return currentState;
    }

    public int getCoins(){
        return currentState.getCoins();
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void start() {
        currentState.pressStartButton();
    }

    public void end() {
        System.out.println("Thank you for playing. See you soon!");
    }
}
