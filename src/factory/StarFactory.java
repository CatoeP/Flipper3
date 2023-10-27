package factory;

public class StarFactory implements MainFactory {


    private Ball ballOne = new BallOne();
    private Ball ballTwo = new BallTwo();
    private Ball ballThree = new BallThree();
    private GameOver gameOver = new GameOver1();
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
