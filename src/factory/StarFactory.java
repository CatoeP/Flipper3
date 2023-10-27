package factory;

public class StarFactory implements MainFactory {


    private Ball ballOne = new BallOne2();
    private Ball ballTwo = new BallTwo2();
    private Ball ballThree = new BallThree2();
    private GameOver gameOver = new GameOver2();

    public StarFactory() {
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
