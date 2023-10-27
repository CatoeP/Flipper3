import singleton.PinBallMachine;
import factory.GraffitiFactory;
import factory.MainFactory;
import factory.StarFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PinBallMachine pinBallMachine = PinBallMachine.getInstance();
        pinBallMachine.setState(pinBallMachine.noCredit);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            String input = sc.next();
            switch (input) {
                case "c" -> {
                    pinBallMachine.insertCoin();
                    System.out.println("Choose your design: Graffiti (g) or Star Wars (sw)");
                    String designChoice = sc.next();
                    MainFactory factory;

                    if (designChoice.equals("g")) {
                        factory = new GraffitiFactory();
                        System.out.println("Your Choice: Graffiti");
                    } else if (designChoice.equals("sw")) {
                        factory = new StarFactory();
                        System.out.println("Your Choice: Star Wars");
                    } else {
                        System.out.println("Invalid choice! Default setting = Star Wars");
                        factory = new StarFactory();
                    }

                    pinBallMachine.setFactory(factory);
                    if(pinBallMachine.getState().equals(pinBallMachine.noCredit)){
                        pinBallMachine.setState(pinBallMachine.ready);
                    }
                }
                case "e" -> {
                    pinBallMachine.end();
                    running = false;
                    sc.close();
                }
                case "s" -> {
                    if(pinBallMachine.getState().equals(pinBallMachine.ready)){
                        pinBallMachine.setState(pinBallMachine.play);
                    }
                    else {
                        pinBallMachine.getState().pressStartButton();
                    }
                }
            }
        }
    }
}
