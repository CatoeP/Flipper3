package singleton;

import states.NoCreditState;
import states.PlayState;
import states.ReadyState;
import states.State;
import factory.MainFactory;

public class PinBallMachine {

    private State currentState;
    private static PinBallMachine instance = null;
    private int coins = 0;
    private int finalScore =0;
    private int multiplier=1;
    public NoCreditState noCredit = new NoCreditState(this);
    public ReadyState ready = new ReadyState(this);
    public PlayState play = new PlayState(this);

    //Singleton: Sicherstellen, dass von PinballMachine nur eine Instanz existiert
    public static PinBallMachine getInstance() {
        if (instance == null)
            instance = new PinBallMachine();
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
        return coins;
    }

    public void updateMultiplier(){
        this.multiplier++;
    }

    public int getMultiplier(){
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    public void addPoints(int points){
        finalScore += points;
        updateMultiplier();
        System.out.println("COMBO X" + getMultiplier());
    }

    public int getFinalScore(){
        return finalScore;
    }

    public void reduceCoins(){
        this.coins--;
    }

    public void insertCoin() {
        coins++;
        System.out.println("Coin inserted. Credits: " + getCoins());
    }

    public void start() {
        currentState.pressStartButton();
    }

    public void end() {
        System.out.println("Thank you for playing. See you soon!");
    }

    private MainFactory factory;

    public void setFactory(MainFactory factory) {
        this.factory = factory;
    }

    public MainFactory getFactory() {
        return this.factory;
    }

}
