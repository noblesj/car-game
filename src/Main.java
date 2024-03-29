import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow();
        gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameWindow.setSize(600, 200);
        gameWindow.setVisible(true);
    }
}