import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Second Window");
        setSize(300, 200);
        setLocation(450, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
//Commented the GameWindow code below
/*
public class GameWindow extends JFrame {
    //start ui
    public GameWindow() {
        super("Car Racing Game");
        initialize();
        createGUI();
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
 */
