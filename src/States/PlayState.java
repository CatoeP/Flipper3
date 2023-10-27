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
import Visitor.ResetVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayState extends State {

    int finalScore = 0;
    int balls = 3;
    private Scanner sc = new Scanner(System.in);
    Random random = new Random();
    List<FlipperElement> flipperElements = new ArrayList<>();
    MakroCommand makro = new MakroCommand();

    public PlayState(PinBallMachine machine) {
        super(machine);
    }

    @Override
    public void pressStartButton() {
        System.out.println("This Pinball Automation was developed by \n Karin König \n Spyridoula Arvaniti \n Katharina Prokopovic");
    }

    @Override
    public void info() {
        if (balls == 0) {
            System.out.println("Game over.");
        } else {
            System.out.println("Okay, Let's play! \n Use the left/right arrow keys");
            System.out.println("BALL " + balls);
            System.out.println("You pull the plunger and - realeased the ball!");
            System.out.println("The ball rolls fast into the arena!");
            play();
        }
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

        generateElements();

        //Möglichkeit, Elemente zu treffen direkt nach Balleinwurf
        boolean ballInPlay = randomHitGenerator();

        String input;

        //Falls beim Balleinwurf direkt Loch getroffen wird
        if (!ballInPlay) {
            System.out.println("Bad luck! You immediately fell into a hole..");
        }
        while (ballInPlay) {
            input = sc.next();
            if (input.equals("l") || input.equals("r")) {
                ballInPlay = randomHitGenerator();
            } else if (input.equals("s")) {
                pressStartButton();
            } else {
                System.out.println("Bad input. PLease only use 'l' or 'r' while in game.");
            }
        }
        sc.close();
        info();

    }

    public boolean randomHitGenerator() {

        //Zufallszahl zw 1&100 generieren und Ergebnis nach Trefferwahrscheinlichkeit erhalten, zB 10% f. Target
        int randomNumber = random.nextInt(100) + 1;

        //boolean remove: wenn true, handelt es sich um ein element, das nach hit vom spielfeld verschwindet
        if (randomNumber <= 10 && checkAndRemoveElement(Target.class, true)) {
            System.out.println("Hit a target!");
            return true;
        } else if (randomNumber <= 30 && checkAndRemoveElement(Ramp.class, true)) {
            System.out.println("Hit a Ramp");
            return true;
        } else if (randomNumber <= 70 && checkAndRemoveElement(Ramp.class, false)) {
            System.out.println("Hit a bumper");
            return true;
        } else {
            System.out.println("Hit a hole");
            ballLost();
            return false;
        }
    }

    //Prüft, ob ein bestimmtes Element noch vorhanden ist, entfernt es vom spielfeld & fügt punkte hinzu ggf.
    public boolean checkAndRemoveElement(Class<?> elementType, boolean remove) {
        for (FlipperElement element : flipperElements) {
            if (elementType.isInstance(element)) {
                makro.addCommand(new HitCommand(element));
                if (remove && element.getState()) {
                    CloseCommand close = new CloseCommand(element);
                    close.execute();
                }
                return true;
            }
        }
        return false;
    }

    public void ballLost() {
        balls--;
        System.out.println("Ball lost. " + balls + " balls left.");

        //Elemente zurücksetzen mit Makrocommand
        System.out.println("Resetting all elements...");
        MakroCommand makro = new MakroCommand();

        for (FlipperElement element : flipperElements) {
            makro.addCommand(new ResetCommand(element));
        }
        makro.execute();
    }

}
