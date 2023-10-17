/*Hier werden die Bälle initialisiert
 */

public class ReadyState implements State{
    int balls =3;

    public ReadyState(){
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
        System.out.println("Test");

    }
}
