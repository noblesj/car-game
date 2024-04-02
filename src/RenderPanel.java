import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
    /**
      *@Author Ramiz
     */
class RenderPanel extends JPanel {
    private Car[] cars;
    private Image backgroundImage;

    public RenderPanel(Car[] cars) {
        this.cars = cars;
        try {
            backgroundImage = ImageIO.read(new File("src/images/trackNEW.png"));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }

        // Draw cars
        for (Car car : cars) {
            car.draw(g);
        }
    }
}