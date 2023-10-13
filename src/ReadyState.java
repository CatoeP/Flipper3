public class ReadyState implements State{

    private int balls;

    public ReadyState(){
        this.info();
    }

    @Override
    public void insertCoin(int coins) {
        System.out.println("Coin inserted. New Credits: " + coins);
    }

    @Override
    public void pressStartButton() {

    }

    @Override
    public void info() {
        System.out.println("Your game is ready! Type 's' to play.");
        System.out.println("Balls: " + balls);

    }
}
