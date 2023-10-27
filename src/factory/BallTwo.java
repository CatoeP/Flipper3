package factory;


public class BallTwo implements Ball {
    @Override
    public String showBall() {
        return ".______        ___       __       __          ___   \n" +
                "|   _  \\      /   \\     |  |     |  |        |__ \\  \n" +
                "|  |_)  |    /  ^  \\    |  |     |  |           ) | \n" +
                "|   _  <    /  /_\\  \\   |  |     |  |          / /  \n" +
                "|  |_)  |  /  _____  \\  |  `----.|  `----.    / /_  \n" +
                "|______/  /__/     \\__\\ |_______||_______|   |____| \n";
    }
}
