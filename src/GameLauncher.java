import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {
    private JComboBox<Integer> numCarsComboBox;
    private JButton startButton;

    public GameLauncher(GameWindow gameWindow) {
        setTitle("First Window");
        setSize(300, 200);
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Integer[] numCarsOptions = {2, 3, 4, 5};
        numCarsComboBox = new JComboBox<>(numCarsOptions);
        numCarsComboBox.setSelectedItem(null);

        startButton = new JButton("Start");
        startButton.setEnabled(false);

        numCarsComboBox.addActionListener(e -> {
            if (numCarsComboBox.getSelectedItem() != null) {
                startButton.setEnabled(true);
            } else {
                startButton.setEnabled(false);
            }
        });

        startButton.addActionListener(e -> {
            setVisible(false);
            gameWindow.setVisible(true);
        });

        JPanel panel = new JPanel();
        panel.add(numCarsComboBox);
        panel.add(startButton);

        getContentPane().add(panel, BorderLayout.CENTER);
    }
}
