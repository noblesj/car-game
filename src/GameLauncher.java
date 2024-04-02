import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
    /*
     *THis class use used to make gui for the first  scene, asking the player
     * if they want to start the car racing game and ask for how many cars
     * they want
     * @Author Jin,Ramiz
    */
public class GameLauncher extends JFrame {
    public GameLauncher(GameWindow gameWindow) {
        super("Car Racing Game");
        setSize(300, 200);
        setLocation(450, 100);

        JPanel controlPanel = new JPanel();
        JButton startRaceButton = new JButton("Start Race");
        startRaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getMaxNumberOfCarsFromUser();
                setVisible(false);
                gameWindow.setVisible(true);
            }
        });
        controlPanel.add(startRaceButton);
        add(controlPanel, BorderLayout.NORTH);

    }

    private int getMaxNumberOfCarsFromUser() {
        for (int i=0; i<4; i++){
            String input = JOptionPane.showInputDialog(null, "Enter maximum number of cars:(up to 4)");
            try {
                int numCars = Integer.parseInt(input);
                if (numCars > 0 && numCars <= 4) {
                    return numCars;
                } else {
                    JOptionPane.showMessageDialog(null, "Invaild input. Please enter a number between 1-4");
                }
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
            }
}
            JOptionPane.showMessageDialog(null, "Invalid input. Defaulting to 2 cars.");
            return 2; // Default to 2 cars if input is invalid
        }

}
