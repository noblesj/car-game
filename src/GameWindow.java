import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {
    private Car car;
    private RenderPanel renderPanel;

    public GameWindow() {
        car = new Car("src/images/carBLUE.png", 250, 250,25,50);
        renderPanel = new RenderPanel(car);
        add(renderPanel);
        setKeyBindings();

        setTitle("Car Movement Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 1000));
        setLocationRelativeTo(null);
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
}
