package factory;


public class BallOne implements Ball {
    @Override
    public String showBall() {
        return ".______        ___       __       __          __  \n" +
                "|   _  \\      /   \\     |  |     |  |        /_ | \n" +
                "|  |_)  |    /  ^  \\    |  |     |  |         | | \n" +
                "|   _  <    /  /_\\  \\   |  |     |  |         | | \n" +
                "|  |_)  |  /  _____  \\  |  `----.|  `----.    | | \n" +
                "|______/  /__/     \\__\\ |_______||_______|    |_| \n";
    }
}
