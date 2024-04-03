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
            {625, 170},
            {490, 450},
            {125, 360},
    };

    private int[][] endPositions = {
            {279, 84},
            {489, 449},
            {624, 169},
            {124, 359},
    };

    private int[][] curvePositions = {
            {281,85},
            {380,285},
            {180,285},
            {180,380}
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
            Car car = new Car(carImagePaths[i], x, y, 100, 50,15,30); // Width and height are set here
            car.rotate(90*(i+1));
            cars[i] = car;
        }
        renderPanel = new RenderPanel(cars);
        add(renderPanel);
    }


    private void moveLogic() {
        new Thread(() -> {
            boolean stop = false;
            while (!stop) {
                // Assuming Car class has methods to check position and to rotate
                SwingUtilities.invokeLater(() -> {
                    for (Car car : cars) {
                        car.moveForwardOrBackward(-car.getSpeed()); // Move each car forward by 1 unit
                        // Check if a car has reached any of the curve positions
                        for (int[] curvePosition : curvePositions) {
                            if (car.getInitialX() == curvePosition[0] && car.getInitialY() == curvePosition[1]){
                                car.rotate(90);
                            }
                        }
                    }
                    renderPanel.repaint(); // Repaint the panel to update car positions
                });

                try {
                    Thread.sleep(100); // Sleep to control the speed of the loop
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    stop = true; // Stop the loop if the thread is interrupted
                }
            }
        }).start();
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
