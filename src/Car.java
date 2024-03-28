package cargame.src;

public class Car {

    private String colorCar;
    private double engine;
    private double tires;
    private double boost;
    private double calculatedSpeed;
    private int startPosition;
    private int endPosition;

    public Car(){
        colorCar = "Not Set";
        engine = 0.0;
        tires = 0.0;
        boost = 0.0;
        calculatedSpeed = 0.0;
        startPosition = 0;
        endPosition = 0;
    }

    public Car(String colorCar,int startPosition, int endPosition) {
        engine = (Math.random() * 3) + 2;
        tires = (Math.random() * 3) + 2;
        if ((int)(Math.random() * 3 + 1) == 1) {
            boost = 1;
        } else {
            boost = 0;
        }
        this.colorCar = colorCar;
        this.calculatedSpeed = engine + tires + boost;
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    //GETTERS
    public String getColor(){
        return colorCar;
    }

    public double getEngine(){
        return engine;
    }

    public double getTires(){
        return tires;
    }

    public double getBoost(){
        return boost;
    }

    public double getCalculatedSpeed() {
        return calculatedSpeed;
    }

    public int getStartPosition() {
        return startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }


    //SETTERS
    public void setColor(String a){
        colorCar = a;
    }

    public void setEngine(int a){
        engine = a;
    }

    public void setTires(int a){
        tires = a;
    }

    public void setBoost(double a){
        boost = a;
    }

    public void setCalculatedSpeed(double calculatedSpeed) {
        this.calculatedSpeed = calculatedSpeed;
    }

    public void setStartPosition(int a){
        startPosition = a;
    }

    public void setEndPosition(int a){
        endPosition = a;
    }


}