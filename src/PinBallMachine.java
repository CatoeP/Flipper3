import FlipperElements.FlipperElement;
import States.NoCreditState;
import States.ReadyState;
import States.State;

public class PinBallMachine {

    int coins;
    private State currentState;

    public PinBallMachine() {
        currentState = new NoCreditState();
        currentState.info();
    }

    public void insertCoin() {
        coins++;
        if (currentState instanceof NoCreditState) {
            currentState = new ReadyState();
        }
        currentState.insertCoin(coins);
    }

    public void start() {
        currentState.pressStartButton();
        if (currentState instanceof ReadyState) {
            coins--;
        }
    }

    public void hitFlipperElement(FlipperElement element) {
        Command command = new HitCommand(element);
        command.execute();
    }

    public void end() {
        System.out.println("Thank you for playing. See you soon!");
    }
}
