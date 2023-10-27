package Singleton;

import States.NoCreditState;
import States.PlayState;
import States.ReadyState;

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
                    pinBallMachine.start();
                    if(pinBallMachine.getState().equals(pinBallMachine.ready)){
                        pinBallMachine.setState(pinBallMachine.play);
                    }
                }
            }
        }


    }
}
