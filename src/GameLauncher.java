import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameLauncher extends JFrame {
    public GameLauncher(GameWindow gameWindow) {
        super("Car Racing Game");
        setSize(300, 200);
        setLocation(450, 100);

        JPanel controlPanel = new JPanel();
        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMaxNumberOfCarsFromUser();
                setVisible(false);
                gameWindow.setVisible(true);
            }
        });
        controlPanel.add(startRaceButton);
        add(controlPanel, BorderLayout.NORTH);

    }

    private int getMaxNumberOfCarsFromUser() {
        String input = JOptionPane.showInputDialog(null, "Enter maximum number of cars:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Defaulting to 2 cars.");
            return 2; // Default to 2 cars if input is invalid
        }
    }
}
