/*Hier werden die Bälle initialisiert

 */

public class ReadyState implements State{
    int balls;

    public ReadyState(){
        this.balls = 3;
        this.info();
    }

    @Override
    public void insertCoin(int coins) {
        System.out.println("Coin inserted. New Credits: " + coins);
    }

    @Override
    public void pressStartButton() {
        System.out.println("Starting the game...");
        PlayState newGame = new PlayState(balls);
    }

    @Override
    public void info() {
        System.out.println("Your game is ready! Type 's' to play.");
    }
}
