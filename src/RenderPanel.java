import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class RenderPanel extends JPanel {
    private Car car;
    private Image backgroundImage;

    public RenderPanel(Car car) {
        this.car = car;
        try {
            backgroundImage = ImageIO.read(new File("src/images/track.png"));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundImage = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        } else {
            g.setColor(Color.GRAY);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
        }
        Graphics2D g2d = (Graphics2D) g.create();
        car.draw(g2d);
        g2d.dispose();
    }

}
