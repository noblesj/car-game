import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        GameWindow gameWindow = new GameWindow();
        GameLauncher gameLauncher = new GameLauncher(gameWindow);


        gameLauncher.setVisible(true);
    }
}