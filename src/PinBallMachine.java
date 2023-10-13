public class PinBallMachine {

    int coins;
    private State currentState;

    public PinBallMachine() {
        currentState = new NoCreditState();
        currentState.info();
    }

    public void insertCoin() {
        coins++;
        if (currentState.getClass().getName().equals("NoCreditState")) {
            currentState = new ReadyState();
        }
        currentState.insertCoin(coins);
    }

    public void start() {
        if (currentState.getClass().getName().equals("ReadyState")) {
            currentState = new PlayState();
        } else {
            currentState.pressStartButton();
        }

    }

    public void end() {
        System.out.println("Thank you for playing. See you soon!");
    }
}
