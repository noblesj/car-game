import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow() {
        super("Car Racing Game");
        setSize(300, 200);
        setLocation(450, 100);
        createGUI();
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
    private void createCars(){
        int numberofcars= getMaxNumberOfCarsFromUser();

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
    private void startRace(){

        createCars();
    }
}
