/**
 * The entry point of the application is responsible for launching the game.
 * It starts by setting up the game window and game launcher window, getting them all set for the user.
 * This class focuses on getting everything set up and showing the first GUI components,
 * essentially serving as the starting point for the car racing game application.
 * @Author Ramiz
 */

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        GameWindow gameWindow = new GameWindow();
        GameLauncher gameLauncher = new GameLauncher(gameWindow);
        gameLauncher.setVisible(true);
    }
}