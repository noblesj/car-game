import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
    private Car car;
    private RenderPanel renderPanel;
    private long startTime; // Record the start time
    private long endTime; // Record the end time

    public GameWindow() {
        car = new Car("src/images/carBLUE.png", 250, 250,25,50);
        renderPanel = new RenderPanel(car);
        add(renderPanel);
        setKeyBindings();

        setTitle("Car Movement Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 1000));
        setLocationRelativeTo(null);
        startRace();
    }

    private void setKeyBindings() {
        InputMap inputMap = renderPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = renderPanel.getActionMap();

        // Rotate left
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "rotateLeft");
        actionMap.put("rotateLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.rotate(-10); // Rotate 10 degrees to the left
                renderPanel.repaint();
            }
        });

        // Rotate right
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rotateRight");
        actionMap.put("rotateRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.rotate(10); // Rotate 10 degrees to the right
                renderPanel.repaint();
            }
        });

        // Move forward
        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveForward");
        actionMap.put("moveForward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.moveForwardOrBackward(-10); // Move 10 pixels forward (in the car's direction)
                renderPanel.repaint();
                if (car.hasReachedEnd() && endTime == 0) {
                    endTime = System.currentTimeMillis(); // Record the end time
                    displayRaceResults();
                }
            }
        });

        // Move backward
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveBackward");
        actionMap.put("moveBackward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.moveForwardOrBackward(10); // Move 10 pixels backward (in the car's direction)
                renderPanel.repaint();
            }
        });
    }
    private void displayRaceResults() {
        long elapsedTime = endTime - startTime; // Calculate the elapsed time
        double seconds = elapsedTime / 1000.0; // Convert milliseconds to seconds
        JOptionPane.showMessageDialog(null, "Race completed in " + seconds + " seconds", "Race Results", JOptionPane.INFORMATION_MESSAGE);
    }
    public void startRace() {
        startTime = System.currentTimeMillis(); // Record the start time when the race starts
    }
}
