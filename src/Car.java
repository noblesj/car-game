import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Car {
    private Image image;

    private int x, y;

    private int width, height;

    private  double rotationAngle = 0; //radians

//    private String colorCar;
//    private double engine;
//    private double tires;
//    private double boost;
//    private double calculatedSpeed;
//    private int startPosition;
//    private int endPosition;

//    public Car(){
//        colorCar = "Not Set";
//        engine = 0.0;
//        tires = 0.0;
//        boost = 0.0;
//        calculatedSpeed = 0.0;
//        startPosition = 0;
//        endPosition = 0;
//    }

    public Car(String imagePath, int x, int y, int width, int height) {
//        engine = (Math.random() * 3) + 2;
//        tires = (Math.random() * 3) + 2;
//        if ((int)(Math.random() * 3 + 1) == 1) {
//            boost = 1;
//        } else {
//            boost = 0;
//        }
//        this.colorCar = colorCar;
//        this.calculatedSpeed = engine + tires + boost;
//        this.startPosition = startPosition;
//        this.endPosition = endPosition;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        loadImage(imagePath);
    }

    private void loadImage(String imagePath) {
        ImageIcon carIcon = new ImageIcon(imagePath);
        Image tempImage = carIcon.getImage();
        image = tempImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public void rotate(double degrees) {
        rotationAngle += Math.toRadians(degrees);
        rotationAngle = rotationAngle % (2*Math.PI);
    }

    public void moveForward(int distance) {
        x += distance * Math.sin(rotationAngle);
        y -= distance * Math.cos(rotationAngle);
    }

    public void moveBackward(int distance) {
        x -= distance * Math.sin(rotationAngle);
        y += distance * Math.cos(rotationAngle);
    }

    public Image getImage() {
        BufferedImage rotatedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rotatedImage.createGraphics();
        AffineTransform at = AffineTransform.getTranslateInstance(width / 2.0, height / 2.0);
        at.rotate(rotationAngle);
        at.translate(-width / 2.0, -height / 2.0);
        g2d.drawImage(image, at, null);
        g2d.dispose();
        return rotatedImage;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    //GETTERS
//    public String getColor(){
//        return colorCar;
//    }
//
//    public double getEngine(){
//        return engine;
//    }
//
//    public double getTires(){
//        return tires;
//    }
//
//    public double getBoost(){
//        return boost;
//    }
//
//    public double getCalculatedSpeed() {
//        return calculatedSpeed;
//    }
//
//    public int getStartPosition() {
//        return startPosition;
//    }
//
//    public int getEndPosition() {
//        return endPosition;
//    }
//
//
//    //SETTERS
//    public void setColor(String a){
//        colorCar = a;
//    }
//
//    public void setEngine(int a){
//        engine = a;
//    }
//
//    public void setTires(int a){
//        tires = a;
//    }
//
//    public void setBoost(double a){
//        boost = a;
//    }
//
//    public void setCalculatedSpeed(double calculatedSpeed) {
//        this.calculatedSpeed = calculatedSpeed;
//    }
//
//    public void setStartPosition(int a){
//        startPosition = a;
//    }
//
//    public void setEndPosition(int a){
//        endPosition = a;
//    }
}