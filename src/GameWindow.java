/**
 * Set up application window here, and display the game
 * intitialize()
 * This method sets up the window properties ( size, title, and etc.. )
 * addComponents()
 * Adds the game compenents ( like the race track) to the window.
 * other methods if necessary
 */
import javax.swing.*;

public class Gamewindow extends JFrame {
    // start ui
    public CarRacingGameGUI() {
        super("Car Racing Game");
        maxNumberOfCars = getMaxNumberOfCarsFromUser();
        carIcons = new ArrayList<>();
        initializeRace();
        createGUI();
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
    }
    private void initializeRace() {
}