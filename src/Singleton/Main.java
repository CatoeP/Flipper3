package Singleton;

import States.NoCreditState;
import States.PlayState;
import States.ReadyState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var pinBallMachine = PinBallMachine.getInstance();
        NoCreditState noCredit = new NoCreditState(pinBallMachine);
        ReadyState ready = new ReadyState(pinBallMachine);
        PlayState play = new PlayState(pinBallMachine);
        pinBallMachine.setState(noCredit);

        Scanner sc = new Scanner(System.in);
        boolean running = true;


        while (running) {
            String input = sc.next();
            switch (input) {
                case "c" -> {
                    pinBallMachine.insertCoin();
                    if(pinBallMachine.getState().equals(noCredit)){
                        pinBallMachine.setState(ready);
                    }
                }
                case "e" -> {
                    pinBallMachine.end();
                    running = false;
                    sc.close();
                }
                case "s" -> {
                    pinBallMachine.start();
                    if(pinBallMachine.getState().equals(ready)){
                        pinBallMachine.setState(play);
                    }
                }
            }
        }


    }
}
