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

        car = new Car("src/images/carRED.png", 50, 50, 25, 50);

        Image trackImage = track.getImage();
        int width = trackImage.getWidth(null);
        int height = trackImage.getHeight(null);
        Image backgroundImage = background.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel trackLabel = new JLabel(new ImageIcon(trackImage));
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        carLabel = new JLabel(new ImageIcon(car.getImage()));

        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(width, height));

        layeredPane.add(backgroundLabel, Integer.valueOf(1));
        layeredPane.add(trackLabel, Integer.valueOf(2));
        layeredPane.add(carLabel, Integer.valueOf(3));


        backgroundLabel.setBounds(0, 0, width, height);
        trackLabel.setBounds(0, 0, width, height);
        updateCarLabelPosition();

        this.add(layeredPane);
    }


    private void updateCarLabelPosition() {
        carLabel.setBounds(car.getX(), car.getY(), car.getImage().getWidth(null), car.getImage().getHeight(null));
        this.repaint();  // Repaint the JFrame to reflect the change
    }
    private void addMovementKeyListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        car.moveForward(5);
                        break;
                    case KeyEvent.VK_DOWN:
                        car.moveBackward(5);
                        break;
                    case KeyEvent.VK_LEFT:
                        car.moveLeft(5);
                        break;
                    case KeyEvent.VK_RIGHT:
                        car.moveRight(5);
                        break;
                }
                updateCarLabelPosition();
            }
        });
        this.setFocusable(true);
    }
}
