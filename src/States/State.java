package States;

import Singleton.PinBallMachine;

public abstract class State {

    protected PinBallMachine machine;
    int coins =0;

    public State(PinBallMachine machine){
        this.machine = machine;
    }

    public void insertCoin(){
        coins++;
        System.out.println("Coin inserted. New Credits: " + coins);
    }

    public int getCoins(){
        return coins;
    }

    public abstract void pressStartButton();

    public abstract void info();

}
