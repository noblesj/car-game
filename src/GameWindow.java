import javax.swing.*;
import java.awt.*;


/**
 *this is where the second gui for the actual car game is called and method to
 *run the cargame and who is the winner and how much time the car took to end the race
 * @Author Ramiz, Jin
 */
public class GameWindow extends JFrame {
    private Car[] cars;
    private RenderPanel renderPanel;
    private long startTime;
    private long endTime;
    private int numCars = 4;
    private volatile boolean stop = false;
    private volatile boolean resultsDisplayed = false;


    private JButton startButton;

    private String[] carImagePaths = {
            "src/images/carBLUE.png",
            "src/images/carRED.png",
            "src/images/carYELLOW.png",
            "src/images/carGREEN.png",
    };

    private int[][] initialPositions = {
            {260, 70},
            {690, 155},
            {510, 460},
            {90, 365}
    };

    private int[][] endPositions = {
            {90, 365},
            {260, 70},
            {690, 155},
            {510, 460}
    };

    private int[][] curvePositions = {
            {690, 70},
            {690, 460},
            {80, 460},
            {90, 70}
    };

    public GameWindow() {
        setTitle("Car Movement Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);

        prepareAndShowGameWindow();
        moveLogic();
        startRace();
    }

    private void prepareAndShowGameWindow() {
        cars = new Car[numCars];
        for (int i = 0; i < numCars; i++) {
            int x = initialPositions[i][0];
            int y = initialPositions[i][1];
            Car car = new Car(carImagePaths[i], x, y, 100, 50, 15, 30);
            car.rotate(90 * (i + 1));
            cars[i] = car;
        }
        renderPanel = new RenderPanel(cars);
        add(renderPanel);
    }

    private void moveLogic() {
        new Thread(() -> {
            while (!stop) {
                SwingUtilities.invokeLater(() -> {
                    for (int i = 0; i < cars.length; i++) {
                        int carIndex = i;
                        Car car = cars[carIndex];
                        car.moveForwardOrBackward(-car.getSpeed());
                        boolean nearAnyCurve = false;
                        for (int[] curvePosition : curvePositions) {
                            if (Math.abs(car.getInitialX() - curvePosition[0]) < 10 && Math.abs(car.getInitialY() - curvePosition[1]) < 10) {
                                if (!car.isProcessingCurve()) {
                                    car.rotate(90);
                                    car.setProcessingCurve(true); // Mark as processing this curve
                                }
                                nearAnyCurve = true; // The car is near at least one curve
                                break; // No need to check other curves
                            }
                        }
                        if (!nearAnyCurve) {
                            car.setProcessingCurve(false);
                        }
                        // Check if the car has reached its end position
                        if (hasReachedEnd() && !resultsDisplayed) {
                            stop = true;
                            displayRaceResults(carIndex); // Pass the index of the car that reached the end
                            resultsDisplayed = true;
                        }
                    }
                    renderPanel.repaint();
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                    stop = true;
                }
            }
        }).start();
    }

    private boolean hasReachedEnd() {
        for (int i = 0; i < cars.length; i++) {
            Car car = cars[i];
            if (Math.abs(car.getInitialX() - endPositions[i][0]) < 10 && Math.abs(car.getInitialY() - endPositions[i][1]) < 10) {
                endTime = System.currentTimeMillis(); // Record the end time
                return true;
            }
        }
        return false;
    }

    private void displayRaceResults(int carIndex) {
        if (!resultsDisplayed) {
            long elapsedTime = endTime - startTime; // Calculate the elapsed time
            double seconds = elapsedTime / 1000.0; // Convert milliseconds to seconds
            JOptionPane.showMessageDialog(null, "Race completed by car " + (carIndex + 1) + " in " + seconds + " seconds", "Race Results", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void startRace() {
        startTime = System.currentTimeMillis(); // Record the start time when the race starts
    }
}