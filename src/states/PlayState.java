package states;

import commands.CloseCommand;
import commands.HitCommand;
import commands.MakroCommand;
import commands.ResetCommand;
import flipperElements.Bumper;
import flipperElements.FlipperElement;
import flipperElements.Ramp;
import flipperElements.Target;
import singleton.PinBallMachine;
import factory.MainFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayState extends State {

    int balls;
    Scanner sc = new Scanner(System.in);
    String input;
    Random random = new Random();
    List<FlipperElement> flipperElements = new ArrayList<>();
    MakroCommand ScoreMakro = new MakroCommand();



    public PlayState(PinBallMachine machine) {
        super(machine);
        resetBalls();
        generateElements();
    }


    @Override
    public void pressStartButton() {
        System.out.println("This Pinball Automation was developed by \n Karin König \n Spyridoula Arvaniti \n Katharina Prokopovic");
    }

    @Override
    public void info() {

        String ballImage = getBallImage(balls);

        System.out.println(ballImage);
        System.out.println("Okay, Let's play! \n Use left (l) / right (r) to flip the ball");
        System.out.println("You pull the plunger and - realeased the ball!");
        System.out.println("The ball rolls fast into the arena!");
        play();
    }

    private String getBallImage(int ballNumber) {
        MainFactory factory = machine.getFactory();
        switch(ballNumber) {
            case 3:
                return factory.createBall1();
            case 2:
                return factory.createBall2();
            case 1:
                return factory.createBall3();
            default:
                throw new IllegalArgumentException("Invalid ball number");
        }
    }

    public void generateElements() {
        flipperElements.add(new Ramp());
        flipperElements.add(new Ramp());
        flipperElements.add(new Target());
        flipperElements.add(new Target());
        flipperElements.add(new Target());
        flipperElements.add(new Bumper());
        flipperElements.add(new Bumper());
        flipperElements.add(new Bumper());
    }

    public void resetBalls(){
        this.balls = 3;
    }

    public void play() {

        //Möglichkeit, Elemente zu treffen direkt nach Balleinwurf
        boolean ballInPlay = randomHitGenerator();

        //Falls beim Balleinwurf direkt Loch getroffen wird
        if (!ballInPlay) {
            System.out.println("Bad luck! You immediately fell into a hole..");
        }
        while (ballInPlay) {
            input = sc.next();
            if (input.equals("l") || input.equals("r")) {
                ballInPlay = randomHitGenerator();
            } else if (input.equals("s")) {
                machine.getState().pressStartButton();
            } else if (input.equals("c")) {
                machine.insertCoin();
            } else {
                System.out.println("Bad input. Please only use 'l' or 'r' while in game.");
            }
        }
        ballLost();
    }

    public boolean randomHitGenerator() {

        //Zufallszahl zw 1&100 generieren und Ergebnis nach Trefferwahrscheinlichkeit erhalten, zB 10% f. Target
        int randomNumber = random.nextInt(100) + 1;

        //boolean remove: wenn true, handelt es sich um ein element, das nach hit vom spielfeld verschwindet
        if (randomNumber <= 10) {
            return checkAndRemoveElement(Target.class);
        } else if (randomNumber <= 30) {
            return checkAndRemoveElement(Ramp.class);
        } else if (randomNumber <= 70) {
            return checkAndRemoveElement(Bumper.class);
        } else {
            return false;
        }
    }

    //Prüft, ob ein bestimmtes Element noch vorhanden (isOpen/isVisible) ist, entfernt es vom spielfeld & fügt punkte hinzu.
    public boolean checkAndRemoveElement(Class<?> elementType) {
        for (FlipperElement element : flipperElements) {
            if (elementType.isInstance(element) && element.getState()) {
                ScoreMakro.addCommand(new HitCommand(element, machine));
                CloseCommand close = new CloseCommand(element, machine);
                close.execute();
                return true;
            }
        }
        return false;
    }

    public void ballLost() {
        balls--;
        PinBallMachine.getInstance().setMultiplier(1);

        ScoreMakro.execute();

        if (balls == 0) {
            machine.reduceCoins();
            MainFactory currentFactory = machine.getFactory();
            if (currentFactory != null) {
                String gameOverImage = currentFactory.createGameOver();
                System.out.println(gameOverImage);
                System.out.println("Ball lost. Game over.\nYour final Score is: " + machine.getFinalScore() + "\nCredits: " + machine.getCoins());

            }
            else {
                System.out.println("Ball lost. Game over.\nYour final Score is: " + machine.getFinalScore() + "\nCredits: " + machine.getCoins());
            }
            if (machine.getCoins() > 0) {
                machine.setState(machine.ready);

            } else {
                machine.setState(machine.noCredit);
            }
            resetBalls();

        } else {
            System.out.println("Ball lost. " + balls + " balls left.");
            System.out.println("Your Score is: " + machine.getFinalScore());
            machine.setState(machine.ready);

            //Elemente zurücksetzen mit Makrocommand
            System.out.println("Resetting all elements...");
            MakroCommand makro = new MakroCommand();

            for (FlipperElement element : flipperElements) {
                makro.addCommand(new ResetCommand(element, machine));
            }
            makro.execute();
        }
    }

}
