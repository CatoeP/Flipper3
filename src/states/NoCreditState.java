package states;

public class NoCreditState implements State {

    @Override
    public void insertCoin(int coins) {
        System.out.println("Coin inserted. New Credits: " + coins);
    }

    @Override
    public void pressStartButton() {
        System.out.println("No credits. Please insert coins.");
    }

    public void info(){
        System.out.println("No credits. Please insert coins by typing 'c'. \n You can insert coins anytime.");
    }
}
