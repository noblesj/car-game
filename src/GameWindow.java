import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame {
    private Car car;
    private JLabel carLabel;

    public GameWindow() {
        setTitle("Main Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initializeComponents();
        addMovementKeyListener();
        setResizable(false);
        this.pack();
    }

    private void initializeComponents() {
        ImageIcon background = new ImageIcon("src/images/background.png");
        ImageIcon track = new ImageIcon("src/images/track.png");

        Image trackImage = track.getImage();
        int width = trackImage.getWidth(null);
        int height = trackImage.getHeight(null);
        Image backgroundImage = background.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel trackLabel = new JLabel(new ImageIcon(trackImage));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));

        layeredPane.add(backgroundLabel, Integer.valueOf(1));
        layeredPane.add(trackLabel, Integer.valueOf(2));


        backgroundLabel.setBounds(0, 0, width, height);
        trackLabel.setBounds(0, 0, width, height);

        this.add(layeredPane);
    }

    private void addMovementKeyListener() {
    }
}
