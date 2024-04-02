import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


/**
  *this is where the second gui for the actual car game is called and method to
  *run the cargame and who is the winner and how much time the car took to end the race
  * @Author Ramiz, Jin
 */
public class GameWindow extends JFrame {
    private Car[] cars;
    private RenderPanel renderPanel;
    private long startTime;
    private int numCars = 4;

    private String[] carImagePaths = {
            "src/images/carBLUE.png",
            "src/images/carRED.png",
            "src/images/carYELLOW.png",
            "src/images/carGREEN.png",
    };

    private int[][] initialPositions = {
            {25, 500},
            {500, 25},
            {25, 250},
            {250, 25},
    };

    private int[][] endPositions = {
            {55, 50},
            {50, 250},
            {250, 25},
            {25, 250},
    };

    public GameWindow() {
        setTitle("Car Movement Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 1000));
        setLocationRelativeTo(null);

        prepareAndShowGameWindow();
        setKeyBindings();
        startRace();
    }

    private void prepareAndShowGameWindow() {
        cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            int x = initialPositions[i][0];
            int y = initialPositions[i][1];
            cars[i] = new Car(carImagePaths[i], x, y, 100, 50,25,50); // Width and height are set here
        }
        renderPanel = new RenderPanel(cars);
        add(renderPanel);
    }

    private void setKeyBindings() {
        InputMap inputMap = renderPanel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = renderPanel.getActionMap();

        // Rotate left
        inputMap.put(KeyStroke.getKeyStroke("LEFT"), "rotateLeft");
        actionMap.put("rotateLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) car.rotate(-10);
                renderPanel.repaint();
            }
        });

        // Rotate right
        inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "rotateRight");
        actionMap.put("rotateRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) car.rotate(10);
                renderPanel.repaint();
            }
        });

        // Move forward
        inputMap.put(KeyStroke.getKeyStroke("UP"), "moveForward");
        actionMap.put("moveForward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) car.moveForwardOrBackward(-10);
                renderPanel.repaint();
            }
        });

        // Move backward
        inputMap.put(KeyStroke.getKeyStroke("DOWN"), "moveBackward");
        actionMap.put("moveBackward", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Car car : cars) car.moveForwardOrBackward(10);
                renderPanel.repaint();
            }
        });
    }

    private void startRace() {
        startTime = System.currentTimeMillis(); // Record the start time
    }

}
