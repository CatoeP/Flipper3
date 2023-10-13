import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PinBallMachine pinBallMachine = new PinBallMachine();

        Scanner sc = new Scanner(System.in);
        boolean running = true;


        while (running) {
            String input = sc.next();
            switch (input) {
                case "c" -> pinBallMachine.insertCoin();
                case "e" -> {
                    pinBallMachine.end();
                    running = false;
                    sc.close();
                }
                case "s" -> pinBallMachine.start();
            }
        }
    }
}
