package States;

public class PlayState implements State {

    private int balls;

    public PlayState(int balls){
        this.balls = balls;
        this.info();
    }

    @Override
    public void insertCoin(int coins) {
        System.out.println("Coin inserted. New Credits: " + coins);
    }

    @Override
    public void pressStartButton() {
        System.out.println("This Pinball Automation was developed by \n Karin König \n Spyridoula Arvaniti \n Katharina Prokopovic");
    }

    @Override
    public void info(){
        System.out.println("Okay, Let's play!");
        System.out.println("BALL " + balls);
        System.out.println("You pull the plunger and - realeased the ball!");
        System.out.println("The ball rolls fast into the arena!");

    }

}
