<<<<<<< Updated upstream
=======
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


>>>>>>> Stashed changes
/**
 * Set up application window here, and display the game
 * intitialize()
 * This method sets up the window properties ( size, title, and etc.. )
 * addComponents()
 * Adds the game compenents ( like the race track) to the window.
 * other methods if necessary
 */
<<<<<<< Updated upstream
import javax.swing.*;

public class Gamewindow extends JFrame {
    // start ui
    public CarRacingGameGUI() {
        super("Car Racing Game");
        maxNumberOfCars = getMaxNumberOfCarsFromUser();
        carIcons = new ArrayList<>();
        initializeRace();
        createGUI();
=======
public class GameWindow extends JFrame {
    private Car[] cars;
    private Checkpoint[] checkpoints;
    private RenderPanel renderPanel;
    private long startTime;
    private  long endTime;
    private int numCars = 4;

    private String[] carImagePaths = {
            "src/images/carBLUE.png",
            "src/images/carRED.png",
            "src/images/carYELLOW.png",
            "src/images/carGREEN.png",
    };

    private int[][] initialPositions = {
            {280, 85},
            {490, 450},
            {625, 170},
            {125, 360},
    };

    private int[][] endPositions = {
            {279, 84},
            {489, 449},
            {624, 169},
            {124, 359},
    };

    public GameWindow() {
        setTitle("Car Movement Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        prepareAndShowGameWindow();
        setKeyBindings();
        startRace();
>>>>>>> Stashed changes
    }
    //get number of cars from the user
    private int getMaxNumberOfCarsFromUser() {
        String input = JOptionPane.showInputDialog(null, "Enter maximum number of cars:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Defaulting to 2 cars.");
            return 2; // Default to 2 cars if input is invalid
        }
<<<<<<< Updated upstream
    }
    private void initializeRace() {
}
=======
        renderPanel = new RenderPanel(cars);
        add(renderPanel);

        //Checkpoints for the car to check if it has reached the end of the race and the curve points
        checkpoints = new Checkpoint[8];

        Checkpoint checkpoint1 = new Checkpoint(157, 124, 0);
        checkpoints[0] = checkpoint1;
        Checkpoint checkpoint2 = new Checkpoint(618, 117, 0);
        checkpoints[1] = checkpoint2;
        Checkpoint checkpoint3 = new Checkpoint(630, 427, 0);
        checkpoints[2] = checkpoint3;
        Checkpoint checkpoint4 = new Checkpoint(158, 443, 0);
        checkpoints[3] = checkpoint4;
        Checkpoint checkpointA = new Checkpoint(279, 84, 0);
        checkpoints[4] = checkpointA;
        Checkpoint checkpointB = new Checkpoint(489, 449, 0);
        checkpoints[5] = checkpointB;
        Checkpoint checkpointC = new Checkpoint(624, 169, 0);
        checkpoints[6] = checkpointC;
        Checkpoint checkpointD = new Checkpoint(124, 359, 0);
        checkpoints[7] = checkpointD;

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
                for (Car car : cars) {
                    if (car.hasReachedEnd() && endTime == 0) {
                        endTime = System.currentTimeMillis(); // Record the end time when a car finishes
                        displayRaceResults();

                    }
                }
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

    private void simulator(final Car rcar, final int index) {
        final Checkpoint[] checkpoints; // Assume this is initialized somewhere
        final BufferedImage carImage = rcar.getImage(); // This needs to be a JLabel or similar
        final double angle = checkpoints[index].getAngle();

        // Assuming getPosition returns a Point object with x and y coordinates
        Point startPos = carImage.getLocation();
            Point endPos = new Point((int) checkpoints[index].getXPos(), (int) checkpoints[index].getYPos());

            int distance = (int)Math.sqrt(Math.pow(endPos.x - startPos.x, 2) + Math.pow(endPos.y - startPos.y, 2));
            final int steps = (int) (distance / rcar.getCalculatedSpeed()); // You might need to adjust the calculation
            final int delay = (int)(2500 / steps); // Adjust the denominator to control speed

            final Timer timer = new Timer(delay, null);
        timer.addActionListener(new ActionListener() {
            private int counter = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (counter < steps) {
                    // Calculate the next position based on linear interpolation
                    double fraction = ((double)counter) / steps;
                    int nextX = startPos.x + (int)((endPos.x - startPos.x) * fraction);
                    int nextY = startPos.y + (int)((endPos.y - startPos.y) * fraction);
                    carImage.setLocation(nextX, nextY);
                    counter++;
                }
                }
        });
        timer.start();
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
>>>>>>> Stashed changes
