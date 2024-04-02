import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Car {
    private BufferedImage image;
    private double angle = 0;
    private int x, y;
    private int width, height;

    public Car(String imagePath, int x, int y, int width, int height) {
        try {

            BufferedImage originalImage = ImageIO.read(new File(imagePath));

            this.image = resizeImage(originalImage, width, height);
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {

        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();
        return resizedImage;
    }

    public void rotate(int deltaAngle) {
        angle += Math.toRadians(deltaAngle);
    }

    public void moveForwardOrBackward(int distance) {
        int vertical = (int) (distance * Math.cos(angle));
        int horizontal = (int) (distance * Math.sin(angle));
        this.y += vertical;
        this.x -= horizontal;
    }

    public void draw(Graphics2D g2d) {
        AffineTransform at = AffineTransform.getRotateInstance(angle, x + width / 2.0, y + height / 2.0);
        at.translate(x, y);
        g2d.setTransform(at);
        g2d.drawImage(image, 0, 0, null);
    }

    // Getters and setters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
