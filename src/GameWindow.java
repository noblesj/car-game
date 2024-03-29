import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gamewindow extends JFrame {
    //start ui
    public Gamewindow() {
        super("Car Racing Game");
        initialize();
        addComponents();
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
    private void initializeRace() {
        // Initialize race with locations
        List<LocationStop> locations = new ArrayList<>();
        locations.add(new LocationStop("A"));
        locations.add(new LocationStop("B"));
        locations.add(new LocationStop("C"));
        locations.add(new LocationStop("D"));
    }
    private  void createGUI(){
        JPanel controlPanel = new JPanel();
        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });
        controlPanel.add(startRaceButton);
        add(controlPanel, BorderLayout.NORTH);

    }
}
