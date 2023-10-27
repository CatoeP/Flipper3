package States;

import Commands.CloseCommand;
import Commands.HitCommand;
import Commands.MakroCommand;
import Commands.ResetCommand;
import FlipperElements.Bumper;
import FlipperElements.FlipperElement;
import FlipperElements.Ramp;
import FlipperElements.Target;
import Singleton.PinBallMachine;

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
        balls = 1;
        generateElements();
    }

    @Override
    public void pressStartButton() {
        System.out.println("This Pinball Automation was developed by \n Karin König \n Spyridoula Arvaniti \n Katharina Prokopovic");
    }

    @Override
    public void info() {
        System.out.println("Okay, Let's play! \n Use the left/right arrow keys");
        System.out.println("BALL " + balls);
        System.out.println("You pull the plunger and - realeased the ball!");
        System.out.println("The ball rolls fast into the arena!");
        play();
    }

    public int getBalls() {
        return balls;
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

        ScoreMakro.execute();

        if (balls <= 0) {
            machine.reduceCoins();
            System.out.println("Ball lost. Game over.\nYour final Score is: " + machine.getFinalScore() + "\nCredits: " + machine.getCoins());
            if (machine.getCoins() > 0) {
                machine.setState(machine.ready);
            } else {
                machine.setState(machine.noCredit);
            }
        } else {
            System.out.println("Ball lost. " + balls + " balls left.");

            //Elemente zurücksetzen mit Makrocommand
            System.out.println("Resetting all elements...");
            MakroCommand makro = new MakroCommand();

            for (FlipperElement element : flipperElements) {
                makro.addCommand(new ResetCommand(element, machine));
            }
            makro.execute();
            System.out.println("Press 'p' to continue with the next ball!");

        }
    }

}
