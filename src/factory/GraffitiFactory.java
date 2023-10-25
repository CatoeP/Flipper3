package factory;

public class GraffitiFactory implements MainFactory {

    private Ball ballOne = new BallOne();
    private Ball ballTwo = new BallTwo2();
    private Ball ballThree = new BallThree();
    private GameOver gameOver = new GameOver1();

    public GraffitiFactory() {
    }

    @Override
    public String createBall1() {
        return ballOne.showBall();
    }

    @Override
    public String createBall2() {
        return ballTwo.showBall();
    }

    @Override
    public String createBall3() {
        return ballThree.showBall();
    }

    @Override
    public String createGameOver() {
        return gameOver.showGameOver();
    }
}
